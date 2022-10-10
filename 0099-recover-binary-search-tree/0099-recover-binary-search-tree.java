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

    // 3,2,1
    // 1,2,3
    
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inOrder(TreeNode root){
        if(root == null)
        {
            return;
        }
        inOrder(root.left);
        if(prev != null)
        {
            if(first == null && root.val < prev.val)
            {
                first = prev;
            }
            if(first != null && first.val > root.val)
            {
                second = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}
