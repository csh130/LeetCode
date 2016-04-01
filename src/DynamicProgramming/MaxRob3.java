package DynamicProgramming;

import Tree.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 * */
public class MaxRob3 {
	public int rob(TreeNode root) {
        int[] res=help(root);
        return Math.max(res[0],res[1]);
        
    }
	//depth first search
    public int[] help(TreeNode root){
        if(root==null) return new int[]{0,0};
         int[] res=new int[2];
         int[] left=help(root.left);
         int[] right=help(root.right);
         // 0 means not rob current house, 1 means rob current house;
         // if not rob this house, the max value = max value of left and right;
         res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
         res[1]=root.val+left[0]+right[0];
         return res;
    }
}
