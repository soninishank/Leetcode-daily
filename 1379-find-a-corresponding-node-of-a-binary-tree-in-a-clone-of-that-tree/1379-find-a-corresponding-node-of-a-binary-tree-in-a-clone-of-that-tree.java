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
    

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null && cloned == null) {
            return null;
        }
        return findCloneTreeReference(cloned, target);
    }

    private TreeNode findCloneTreeReference(final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        TreeNode left = findCloneTreeReference(cloned.left, target);
        if(left != null){
            return left;
        }
        return findCloneTreeReference(cloned.right, target);
    }
}
