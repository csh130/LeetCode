package Array;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);

		test bt = new test();
		System.out.println(bt.pathSum(node1, 5));
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<Integer>(), root, sum);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> list,
			TreeNode node, int sum) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		sum -= node.val;
		helper(res, list, node.left, sum);

		if (node.left == null && node.right == null && sum == 0) {
			res.add(new ArrayList(list));
		}

		helper(res, list, node.right, sum);
		list.remove(list.size() - 1);
	}
}

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public String toString() {
		return val + "";
	}
}
