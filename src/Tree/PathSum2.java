package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root != null)
			help(root, sum, list, temp);
		return list;
	}

	public static void help(TreeNode root, int sum, List<List<Integer>> list,
			List<Integer> temp) {
		if (root == null)
			return;
		temp.add(root.val);
		//找到leaf node, 到底以后 判断是否root 的值等于target. 每次循环 把target 减掉sum
		if (root.left == null && root.right == null && root.val == sum) {
			list.add(new ArrayList(temp));
			// 把最后一个元素去除, 路径减掉最后一个node
			temp.remove(temp.size() - 1);
			return;
		} else {
			help(root.left, sum - root.val, list, temp);
			help(root.right, sum - root.val, list, temp);
		}
		//往回 回溯一层
		temp.remove(temp.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
		TreeNode root2 = new TreeNode(-3);
		root.right = root2;
		System.out.println(pathSum(root, -5));

	}
}
