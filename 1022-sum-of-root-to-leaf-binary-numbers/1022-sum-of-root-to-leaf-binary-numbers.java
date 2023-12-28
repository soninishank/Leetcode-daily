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
    int globalSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getTotalSum(root, "");
        return globalSum;
    }

    private void getTotalSum(TreeNode root, String str) {
        if (root == null) {
            return ;
        }
        str += root.val;
        if (root.left == null && root.right == null) {
            int value = Integer.valueOf(str, 2);
            globalSum += value;
            return;
        }
        getTotalSum(root.left,str);
        getTotalSum(root.right,str);
    }
}
