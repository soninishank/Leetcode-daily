/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
          if(root == null)
          {
              return false;
          }
        return checkPathExist(root,targetSum);
    }
    
    private boolean checkPathExist(TreeNode root,int targetSum){
        if(root == null){
            return false;
        }
        targetSum-= root.val;
        if(targetSum == 0 && root.left == null && root.right == null)
        {
            return true;
        }
        return checkPathExist(root.left,targetSum) || checkPathExist(root.right,targetSum);
    }
}