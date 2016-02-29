package Tree;

public class KthSmallestElement {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Solution {
		public int kthSmallest(TreeNode root, int k) {
			// use binary search. Find the nodes count of left tree;
			int l = count(root.left);
			if (k < l + 1) {
				return kthSmallest(root.left, k);
			} else if (k > l + 1)
				return kthSmallest(root.right, k - l - 1);
			return root.val;

		}

		public int count(TreeNode root) {
			if (root == null)
				return 0;
			return count(root.left) + count(root.right) + 1;
		}
	}
}
