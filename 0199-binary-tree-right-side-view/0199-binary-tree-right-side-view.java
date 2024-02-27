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
    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        buildTree(root, 1);
        return result;
    }

    private void buildTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level) {
            result.add(root.val);
        }
        // Pre-Order traversal
        buildTree(root.right, level + 1);
        buildTree(root.left, level + 1);
    }
}
