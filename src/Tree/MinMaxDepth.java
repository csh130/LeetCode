package Tree;

public class MinMaxDepth {

	
	// find the max depth of a binary search tree
	public int maxDepth(TreeNode root){
		if(root==null) return 0;
		// remember to add 1
		return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
		
	}
	
	// find the minimum depth of a binary tree
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null || root.right == null) {
			return 1 + Math.max(minDepth(root.left), minDepth(root.right));
		} else {
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		}
	}
}
