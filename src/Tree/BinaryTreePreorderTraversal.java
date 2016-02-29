package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * */
public class BinaryTreePreorderTraversal {

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root != null) {
				result.add(root.val);
				if (root.left != null) {
					preorderTraversal(root.left);
					preorderTraversal(root.right);
				}

			}
			return result;
		}
	}

	/* 用 stack存right 把所有left都打印输出 right都存在树stack里面 */
	public List<Integer> preorderTraversal(TreeNode node) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while (node != null) {
			list.add(node.val);
			if (node.right != null) {
				rights.push(node.right);
			}
			node = node.left;
			if (node == null && !rights.isEmpty()) {
				node = rights.pop();
			}
		}
		return list;
	}
}
