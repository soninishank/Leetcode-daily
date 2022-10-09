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
   HashMap<Integer, Integer> hashmap = new HashMap<>();
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        doInorderTraversal(root);
        for (Map.Entry<Integer, Integer> entri1 : hashmap.entrySet()) {
            if (entri1.getValue().equals(max)) {
                list.add(entri1.getKey());
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    void doInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        doInorderTraversal(root.left);
        hashmap.put(root.val, hashmap.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, hashmap.get(root.val));
        doInorderTraversal(root.right);
    }
}