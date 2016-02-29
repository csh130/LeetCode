package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Tree.BinaryTreePreorderTraversal.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [3,2,1].
 * */
public class BinaryTreePostorderTraversal {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {

			LinkedList<Integer> list = new LinkedList<Integer>();
			Stack<TreeNode> s = new Stack<TreeNode>();
			while (root != null) {
				list.addFirst(root.val);
				if (root.left != null) {
					s.push(root.left);
				}
				root = root.right; 
				if (root == null && !s.isEmpty()) {
					root=s.pop();
				}
			}

			return list;
		}

		// 用递归实现后序遍历
		public List<Integer> postorderTraversal2(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			if (root != null) {
				list.addAll(postorderTraversal(root.left));
				list.addAll(postorderTraversal(root.right));
				list.add(root.val);

			}
			return list;
		}
	}

}
