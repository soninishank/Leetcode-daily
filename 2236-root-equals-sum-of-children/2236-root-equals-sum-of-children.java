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
    boolean flag = true;

    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        validateSum(root);
        return flag;
    }

    private int validateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null)
        {
            return root.val;
        }
        int left = 0;
        if (root.left != null) {
            left = validateSum(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = validateSum(root.right);
        }
        if (left + right != root.val) {
            flag = false;
        }
        return left + right;
    }
}
