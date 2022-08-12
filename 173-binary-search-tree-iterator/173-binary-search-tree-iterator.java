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
class BSTIterator {

    TreeNode current;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }
    
    public int next() {
       if (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (stack.size() == 0) {
                return 0;
            }
            TreeNode nextNode = stack.pop();
            current = nextNode.right;
            return nextNode.val;
        }
        return 0;
    }
    
    public boolean hasNext() {
        if(current != null || !stack.isEmpty())
        {
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */