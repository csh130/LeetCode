package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrderTraversal2 {
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
		// [3,9,20,#,#,15,7]
		System.out.println(levelOrderBottom2(t1));
	}

	/**
	 * User bread first solution, using queue and linkedlist,
	 * */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> temp = new LinkedList<Integer>();
				for (int i = 0; i < size; i++) {
					TreeNode n = queue.poll();
					temp.add(n.val);
					if (n.left != null)
						queue.offer(n.left);
					if (n.right != null)
						queue.offer(n.right);
				}
				list.add(0, temp);
			}

		}
		return list;

	}

	/**
	 * Another solution, using depth first.
	 * */
	public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
		addLevel(list, 0, root);
		return list;
	}

	private static void addLevel(LinkedList<List<Integer>> list, int level,
			TreeNode node) {
		if (node == null)
			return;
		if (list.size() - 1 < level)
			list.addFirst(new LinkedList<Integer>());
		list.get(list.size() - 1 - level).add(node.val);
		addLevel(list, level + 1, node.left);
		addLevel(list, level + 1, node.right);
	}
}
