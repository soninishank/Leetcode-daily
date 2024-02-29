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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer prevValue = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int val = poll.val;
                // even level
                if (level % 2 == 0) {
                    // odd value
                    if (val % 2 == 0) {
                        return false;
                    }
                    if(prevValue != null && val <= prevValue){
                        return false;
                    }
                } // odd level
                else {
                    // even value
                    if (val % 2 != 0) {
                        return false;
                    }
                    if(prevValue != null && val >= prevValue){
                        return false;
                    }
                }
                prevValue = val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            level++;
        }
        return true;
    }
}
