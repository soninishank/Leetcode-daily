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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE) ;
    }

    private boolean checkBST(TreeNode root, long start, long end) {
        if(root == null){
            return true;
        }
        if (root != null) {
            if (root.val <= start|| root.val >= end) {
                return false;
            }
        }
        return checkBST(root.left, start, root.val) && checkBST(root.right, root.val, end);
    }
}
