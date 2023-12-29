/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxValue = 1;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        maxNode(root, 1);
        return maxValue;
    }

    private void maxNode(Node root, int count) {
        if (root == null) {
            return;
        }
        maxValue = Math.max(maxValue, count);

        if (root.children != null) {
            for (Node child : root.children) {
                maxNode(child, count + 1);
            }
        }
    }
}