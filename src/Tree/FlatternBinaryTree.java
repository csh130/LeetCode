package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 

public class FlatternBinaryTree {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		flatten(n1);
	}

	public static void flatten(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			list.add(cur);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			cur = cur.left;
			if (cur == null && !stack.isEmpty()) {
				cur = stack.pop();
			}
		}
		for (int i = 0; i < list.size() - 1; i++) {
			cur = list.get(i);
			cur.right = list.get(i + 1);
			cur.left = null;
		}
	}
}
