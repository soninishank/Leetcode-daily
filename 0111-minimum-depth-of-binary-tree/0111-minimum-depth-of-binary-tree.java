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
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calculateMinDepth(root, 1);
        return minDepth;
    }

    private void calculateMinDepth(TreeNode root, int count) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, count);
        }
        calculateMinDepth(root.left, count + 1);
        calculateMinDepth(root.right, count + 1);
    }
}
