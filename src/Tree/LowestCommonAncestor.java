package Tree;

public class LowestCommonAncestor {

	// 不要忘记搜索二叉树的性质, 左边值小于爸爸 爸爸小于右子树的值
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 找到任何在 p.q 中间的值, 就是目标值了 要确保这是找到的第一个node
		if (root.val >= Math.min(p.val, q.val)
				&& root.val <= Math.max(p.val, q.val))
			return root;
		// 如果要找的p q 的值都比root的值要小 就在左子树找,不然在右子树找
		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else
			return lowestCommonAncestor(root.right, p, q);
	}
}
