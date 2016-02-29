package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		String tree = "3,9,20,null,null,15,7";

		//System.out.println(serialize(t1));
		System.out.println(deserialize(tree));
		// System.out.println(serialize("1,2,3,null,null,4,5"));
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		String s = "";
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode n = queue.poll();
					if (n == null) {
						s += ",null";
						continue;
					}
					if (n.left != null)
						queue.offer(n.left);
					else
						queue.offer(null);
					if (n.right != null)
						queue.offer(n.right);
					else
						queue.offer(null);
					s += "," + n.val;
				}
			}

		}
		return root == null ? s : s.substring(1, s.length() - 1);
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;
		String arr[] = data.split(",");
		List<TreeNode> list = new ArrayList<TreeNode>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			TreeNode n;
			if (arr[i].equals("null")) {
				n = null;
				list.add(n);
			} else {
				n = new TreeNode(Integer.parseInt(arr[i]));
				list.add(n);
			}

		}
		for (int i = 0; i < list.size(); i++) {
			TreeNode temp = list.get(i);
			if (temp != null) {
				if (2 * (i + 1) - 1 < list.size()) {
					temp.left = list.get(2 * (i + 1) - 1);
					temp.right = list.get(2 * (i + 1));
				}
			}

		}
		return list.isEmpty() ? null : list.get(0);
	}
}
