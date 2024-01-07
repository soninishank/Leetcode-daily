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

    private List<Integer> list;
    int index = 0;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        buildTree(root);
    }
    
    private void buildTree(TreeNode root){
        if(root == null){
            return;
        }
        buildTree(root.left);
        list.add(root.val);
        buildTree(root.right);
    }
    
    public int next() {
        int value = list.get(index);
        index++;
        return value;
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */