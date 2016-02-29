package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRight {
	/**
	 * Definition for binary tree with next pointer. public class TreeLinkNode {
	 * int val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}

	public class Solution {
		// breath first search, using queue
		public void connect(TreeLinkNode root) {
			if (root != null) {
				Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
				queue.offer(root);
				while (!queue.isEmpty()) {
					int size = queue.size();
					for (int i = 0; i < size; i++) {
						TreeLinkNode temp = queue.poll();
						if (i <= size - 2)
							temp.next = queue.peek();
						if (temp.left != null)
							queue.offer(temp.left);
						if (temp.right != null)
							queue.offer(temp.right);
					}
				}
			}
		}

		public void connect2(TreeLinkNode root) {
			TreeLinkNode level_start = root;
			while (level_start != null) {
				TreeLinkNode cur = level_start;
				while (cur != null) {
					if (cur.left != null)
						cur.left.next = cur.right;
					if (cur.right != null && cur.next != null)
						cur.right.next = cur.next.left;

					cur = cur.next;
				}
				level_start = level_start.left;
			}
		}
	}
}
