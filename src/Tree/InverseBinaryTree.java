package Tree;

public class InverseBinaryTree {
	public TreeNode inverseTree(TreeNode root) {
		if (root != null) {
			inverse(root);
		}
		return root;
	}

	void inverse(TreeNode root) {
		if (root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			if (root.left != null)
				inverse(root.left);
			if (root.right != null)
				inverse(root.right);
		}
	}
}
