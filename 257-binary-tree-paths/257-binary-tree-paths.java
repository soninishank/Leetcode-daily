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
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        applyRecursion(root, "");
        return result;
    }

    private void applyRecursion(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            str = str + root.val;
            result.add(str);
            return;
        }
        str += root.val + "->";
        if (root.left != null) {
            applyRecursion(root.left, str);
        }
        if (root.right != null) {
            applyRecursion(root.right, str);
        }
    }
}
