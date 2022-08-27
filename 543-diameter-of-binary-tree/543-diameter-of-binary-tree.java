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
    int count = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getCount(root);
        return count;
    }

    int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getCount(root.left);
        int right = getCount(root.right);
        count =  Math.max(count,left+right);
        return 1 + Math.max(left,right);
    }
}
