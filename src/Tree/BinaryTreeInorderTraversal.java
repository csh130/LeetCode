package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
	/**
	 * Definition for a binary tree node.
	 */

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
		System.out.println(inorderTraversal(n1));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			list.addAll(inorderTraversal(root.left));
			list.add(root.val);
			list.addAll(inorderTraversal(root.right));
		}
		return list;

	}

	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;

		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}

		return list;

	}
}
