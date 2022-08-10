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

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        applyRecursion(root,builder);
        return builder.toString();
    }

    private void applyRecursion(TreeNode root, StringBuilder builder) {
        if(root == null)
        {
            return;
        }
        builder.append(root.val);
        if(root.left != null)
        {
            builder.append("(");
            applyRecursion(root.left,builder);
             builder.append(")");
        }
        if(root.right != null)
        {
            if(root.left == null)
            {
                 builder.append("()");
            }
            builder.append("(");
            applyRecursion(root.right,builder);
             builder.append(")");
        }
    }
}
