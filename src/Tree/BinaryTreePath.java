package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 */

public class BinaryTreePath {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> path = new ArrayList<String>();
		if (root != null && root.left == null && root.right == null)
			path.add(root.val + "");
		if (root != null) {
			help(root.left, root.val + "", path);
			help(root.right, root.val + "", path);

		}
		return path;
	}

	public void help(TreeNode n, String s, List<String> path) {
		if (n == null)
			return;
		s += "->" + n.val;
		// 如果到leaf node,就把路径加到list里面去
		if (n.left == null && n.right == null)
			path.add(s);
		help(n.left, s, path);
		help(n.right, s, path);

	}

	class solution2 {
		public List<String> binaryTreePaths(TreeNode root) {
			List<String> answer = new ArrayList<String>();
			if (root != null)
				searchBT(root, "", answer);
			return answer;
		}

		private void searchBT(TreeNode root, String path, List<String> answer) {
			if (root.left == null && root.right == null)
				answer.add(path + root.val);
			if (root.left != null)
				searchBT(root.left, path + root.val + "->", answer);
			if (root.right != null)
				searchBT(root.right, path + root.val + "->", answer);
		}
	}
}
