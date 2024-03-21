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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return null;
        }
        return solve(1, n);
    }

    private List<TreeNode> solve(int start, int end) {
     List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            result.add(node);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSide = solve(start, i - 1);
            List<TreeNode> rightSide = solve(i + 1, end);

            for (TreeNode leftBST : leftSide) {
                for (TreeNode rightBST : rightSide) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftBST;
                    node.right = rightBST;
                    
                    result.add(node);
                }
            }
        }
        return result;
    }
}
