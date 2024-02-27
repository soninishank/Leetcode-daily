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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxValue(root);
        return maxSum;
    }

    private int getMaxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxValue(root.left);
        int right = getMaxValue(root.right);

        int firstCase = left + right + root.val;
        int secondCase = root.val;
        int thirdCase = Math.max(left, right) + root.val;

        maxSum = Math.max(maxSum, firstCase);
        maxSum = Math.max(maxSum, secondCase);
        maxSum = Math.max(maxSum, thirdCase);
        
        return Math.max(secondCase,thirdCase);
    }
}
