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
class FindElements {

    TreeNode node;
    List<Integer> list;

    public FindElements(TreeNode root) {
        node = root;
        boolean isLeft = false;
        buildTree(node, -1, isLeft);
        list = new ArrayList<>();
        makeList(node,list);
        System.out.println(list);
    }

    void makeList(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            makeList(root.left, list);
            makeList(root.right, list);
        }else
        {
            return;
        }
    }

    void buildTree(TreeNode root, int parent, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (parent == -1) {
            root.val = 0;
        } else if (isLeft) {
            root.val = 2 * parent + 1;
        } else {
            root.val = 2 * parent + 2;
        }
        if (root.left != null) {
            buildTree(root.left, root.val, true);
        }
        if (root.right != null) {
            buildTree(root.right, root.val, false);
        }
    }

    public boolean find(int target) {
        return list.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */