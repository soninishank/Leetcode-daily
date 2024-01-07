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
    int index ;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = 0;
        this._buildTree(root);
    }
    
    private void _buildTree(TreeNode root){
        if(root == null){
            return;
        }
        this._buildTree(root.left);
        list.add(root.val);
        this._buildTree(root.right);
    }
    
    public int next() {
        int value = this.list.get(index);
        this.index++;
        return value;
    }
    
    public boolean hasNext() {
        return this.index < this.list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */