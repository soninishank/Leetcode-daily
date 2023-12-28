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

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        buildResultList(root, sb);
        Collections.sort(result);
        if(result.size() >= 1){
            return result.get(0);
        }
        return "";
    }

    private void buildResultList(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            result.add(sb.reverse().toString());
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        buildResultList(root.left, sb);
        buildResultList(root.right, sb);

        sb.deleteCharAt(sb.length() - 1);
        return;
    }
}
