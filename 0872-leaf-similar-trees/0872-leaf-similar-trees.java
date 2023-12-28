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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> leavesList1 = getLeaves(root1, new ArrayList<>());
        List<Integer> leavesList2 = getLeaves(root2, new ArrayList<>());
        return leavesList1.equals(leavesList2);
    }

    private List<Integer> getLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        getLeaves(root.left, list);
        getLeaves(root.right, list);
        return list;
    }
}
