package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class BinaryTreeInorderTraversal {
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
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			if (root != null) {
				list.addAll(inorderTraversal(root.left));
				list.add(root.val);
				list.addAll(inorderTraversal(root.right));
			}
			return list;

		}

		public List<Integer> inorderTraversal2(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();

			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode cur = root;

			while (cur != null || !stack.empty()) {
				while (cur != null) {
					stack.add(cur);
					cur = cur.left;
				}
				cur = stack.pop();
				list.add(cur.val);
				cur = cur.right;
			}

			return list;
		}
	}
}
