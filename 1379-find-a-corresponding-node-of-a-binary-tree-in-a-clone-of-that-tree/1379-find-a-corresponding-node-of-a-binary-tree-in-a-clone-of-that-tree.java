/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    TreeNode current = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null && cloned == null) {
            return null;
        }
       findCloneTreeReference(cloned, target);
        return current;
    }

    void findCloneTreeReference(final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return ;
        }
        if (cloned.val == target.val) {
            current = cloned;
            return;
        }
        findCloneTreeReference(cloned.left, target);
        findCloneTreeReference(cloned.right, target);
    }
}
