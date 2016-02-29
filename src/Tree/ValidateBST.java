package Tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees. confused what "{1,#,2,3}" means?
 * */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ValidateBST {
	public class Solution {
		public boolean isValidBST(TreeNode root) {
			return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}

		boolean help(TreeNode root, Long min, Long max) {

			if (root == null)
				return true;
			if (root.val <= min || root.val >= max)
				return false;
			return help(root.left, min, (long) root.val)
					&& help(root.right, (long) root.val, max);

		}
	}

}
