package Tree;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * */
public class SymetricTree {
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
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null) return true;
	            return help(root.left,root.right);
	        
	    }
	    
	    public boolean help(TreeNode root1, TreeNode root2){
	        if(root1==null && root2==null) return true;
	        if((root1!=null && root2==null) || (root1==null&& root2!=null)) return false;
	        if(root1.val!=root2.val) return false;
	        return  help(root1.left,root2.right)&  help(root1.right, root2.left);
	    }
	}

}
