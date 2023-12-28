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
        buildTree(result, root, "");
        return result;
    }

    void buildTree(List<String> list, TreeNode root, String str) {
        // Add this condition when you want to go till leaf
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            str += root.val;
            list.add(str);
            return;
        } else {
            str += root.val + "->";
        }
        buildTree(list, root.left, str);
        buildTree(list, root.right, str);
    }
}
