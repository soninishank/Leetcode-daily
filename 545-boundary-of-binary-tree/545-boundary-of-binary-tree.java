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
    List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode node) {
         if (node == null) {
            return result;
        }
        result.add(node.val);
        leftTraversal(node.left);
        bottomView(node.left);
        bottomView(node.right);
        rightView(node.right);
        return result;
    }
    
     void leftTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        result.add(node.val);
        leftTraversal(node.left);
        if (node.left == null) {
            leftTraversal(node.right);
        }
    }

    void bottomView(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(node.val);
        }
        bottomView(node.left);
        bottomView(node.right);
    }

    void rightView(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        rightView(node.right);
        if (node.right == null) {
            rightView(node.left);
        }
        result.add(node.val);
    }
}
