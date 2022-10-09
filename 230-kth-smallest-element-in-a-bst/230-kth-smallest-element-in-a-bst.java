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
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return 0;
        }
        inOrder(root);
        System.out.print(pq);
        while(!pq.isEmpty() && k != 1)
        {
            pq.poll();
            k--;
        }
        return pq.poll();
    }
    
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        pq.add(root.val);
        inOrder(root.right);
    }
}
