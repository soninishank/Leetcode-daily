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
    HashMap<TreeNode, TreeNode> hashmap = new HashMap<>();
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calculateSum(root, null, null);
        return sum;
    }

    private void calculateSum(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null) {
            return;
        }
        if (root != null && grandparent != null && grandparent.val % 2 == 0) {
            sum += root.val;
        }
        calculateSum(root.left, root, parent);
        calculateSum(root.right, root, parent);
    }
}