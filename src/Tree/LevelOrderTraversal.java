package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			// user linkedlist to initial queue
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			List<List<Integer>> list = new ArrayList<List<Integer>>();

			if (root != null) {
				// add the root into queue first
				q.offer(root);
				int size = 0;
				while (!q.isEmpty()) {
					List<Integer> temp = new LinkedList<Integer>();
					// size is the current nodes in the queue. means the same level
					size = q.size();
					for (int i = 0; i < size; i++) {
						// remove nodes of this level. total count size
						TreeNode n = q.poll();
						if (n.left != null)
							q.offer(n.left);
						if (n.right != null)
							q.offer(n.right);

						temp.add(n.val);
					}
					list.add(temp);
				}
			}
			return list;
		}
	}
}
