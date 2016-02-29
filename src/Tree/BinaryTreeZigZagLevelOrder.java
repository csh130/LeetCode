package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrder {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
		System.out.println(zigzagLevelOrder(t1));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.offer(root);
			int level = 0;
			while (!queue.isEmpty()) {
				List<Integer> temp = new LinkedList<Integer>();
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode n = queue.poll();
					if (n.left != null)
						queue.offer(n.left);
					if (n.right != null)
						queue.offer(n.right);
					if (level % 2 == 0)
						temp.add(n.val);
					else
						temp.add(0, n.val);
				}
				level++;
				list.add(temp);
			}

		}
		return list;
	}

	/**
	 * Use depth first, more efficient solution;
	 * */
	public class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> sol = new ArrayList<>();
			travel(root, sol, 0);
			return sol;
		}

		private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
			if (curr == null)
				return;
			if (sol.size() <= level) {
				// create list for every level;
				List<Integer> newLevel = new LinkedList<>();
				sol.add(newLevel);
			}

			// get corresponding level in list by using level as index
			List<Integer> collection = sol.get(level);
			if (level % 2 == 0)
				collection.add(curr.val);
			else
				collection.add(0, curr.val);

			travel(curr.left, sol, level + 1);
			travel(curr.right, sol, level + 1);
		}
	}
}
