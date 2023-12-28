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

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return resultList;
        }
        List<Integer> list = new ArrayList<>();
        checkPathSum(root, targetSum, 0, list);
        return resultList;
    }

    private boolean checkPathSum(TreeNode root, int targetSum, int currentSum, List<Integer> list) {
        if (root == null) {
            return false;
        }
        currentSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                resultList.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return true;
            } else {
                list.remove(list.size() - 1);
                return false;
            }
        }
        boolean left = checkPathSum(root.left, targetSum, currentSum, list);
        boolean right = checkPathSum(root.right, targetSum, currentSum, list);
        list.remove(list.size() - 1);
        return left || right;
    }
}