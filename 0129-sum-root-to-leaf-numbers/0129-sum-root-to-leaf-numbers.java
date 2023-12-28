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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        buildSum(root,"");
        return sum;
    }
    
    private void buildSum(TreeNode root,String str){
        if(root == null){
            return ;
        }
        str += root.val;
        if(root.left == null && root.right == null && str.length() > 0){
            sum += Integer.valueOf(str);
            return;
        }
        buildSum(root.left, str);
        buildSum(root.right, str);
    }
}