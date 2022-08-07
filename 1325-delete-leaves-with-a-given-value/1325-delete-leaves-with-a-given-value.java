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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        return applyRecursion(root, target);
    }

    private TreeNode applyRecursion(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = applyRecursion(root.left, target);
        root.right = applyRecursion(root.right, target);
        // we need to apply this check after - try with both scenarios 
        // put at line no 28 check the output
        if (root.left == null && root.right == null && root.val == target) {
            root = null;
            return root;
        }
        return root;
    }
}
