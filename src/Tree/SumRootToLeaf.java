package Tree;

/**
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * */
public class SumRootToLeaf {

	public class Solution {
		int total = 0;

		public int sumNumbers(TreeNode root) {
			if (root != null)
				sum(root, 0);
			return total;
		}

		public void sum(TreeNode root, int n) {
			if (root == null)
				return;
			n = 10 * n + root.val;

			// if it is the leaf node. has no any children
			if (root.left == null && root.right == null)
				total += n;
			sum(root.left, n);
			sum(root.right, n);
		}
	}
}
