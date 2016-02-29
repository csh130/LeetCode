package Stack;

import java.util.ArrayList;
import java.util.List;

import Tree.BinaryTreePreorderTraversal.TreeNode;


public class Preorder {
public static void main(String[] args) {
	
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root!=null)
        {
        	res.add(root.val);
        	res.addAll(preorderTraversal(root.left));
        	res.addAll(preorderTraversal(root.right));
        }
        
		return res;
        
    }
}
}
