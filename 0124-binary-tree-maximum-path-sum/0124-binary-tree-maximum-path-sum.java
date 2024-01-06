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
// https://www.youtube.com/watch?v=Op6YFcs8R9M - very easy solution
class Solution {
    
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findMax(root.left);
        int right = findMax(root.right);
        
        int firstCase = left + right + root.val;
        int secondCase = Math.max(left,right) + root.val;
        int thirdCase = root.val;
        
        maxSum = Math.max(maxSum, firstCase);
        maxSum = Math.max(maxSum, secondCase);
        maxSum = Math.max(maxSum, thirdCase);

        return Math.max(secondCase, thirdCase); // you can return only this 
    }
}