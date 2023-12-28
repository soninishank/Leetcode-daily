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
    int leafSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLeafSum(root, false);
        return leafSum;
    }

    private void getLeafSum(TreeNode root, boolean isLeftSide) {
        if (root == null) {
            return;
        }
        // check its a leave node - means no left and right child
        if (root.left == null && root.right == null) {
            if (isLeftSide) {
                leafSum += root.val;
            }
        }
        getLeafSum(root.left,true);
        getLeafSum(root.right,false);
    }
}
