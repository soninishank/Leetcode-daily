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
   private PriorityQueue<Integer> pq;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }
        pq = new PriorityQueue<>((a, b) -> Math.abs(a - target) > Math.abs(b - target) ? -1 : 1);
        applyRecursion(root, k);
        return new ArrayList<>(pq);
    }

    private void applyRecursion(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        applyRecursion(root.left, k);
        pq.add(root.val);
        if (pq.size() > k) {
            pq.poll();
        }
        applyRecursion(root.right, k);
    }
}