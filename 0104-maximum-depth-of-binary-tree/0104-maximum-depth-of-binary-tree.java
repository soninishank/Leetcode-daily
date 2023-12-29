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
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calculateMaxDepth(root, 1);
        return maxDepth;
    }

    private void calculateMaxDepth(TreeNode root, int count) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, count);

        calculateMaxDepth(root.left, count + 1);
        calculateMaxDepth(root.right, count + 1);
    }
}
