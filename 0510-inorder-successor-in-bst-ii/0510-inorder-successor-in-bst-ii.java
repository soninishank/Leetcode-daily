/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right != null)
        {
            Node result = node.right;
            while(result.left != null)
            {
                result = result.left;
            }
            return result;
        }else // right is null - example 1 - go to parenr 
        {
            Node result = node.parent;
            while(result != null && result.val < node.val)
            {
                result = result.parent;
            }
            return result;
        }
    }
}