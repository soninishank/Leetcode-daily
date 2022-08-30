/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> hashmap = new HashMap<>();

        hashmap.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbour : current.neighbors) {
                if (!hashmap.containsKey(neighbour)) {
                    Node newNode = new Node(neighbour.val);
                    hashmap.put(neighbour, newNode);
                    queue.add(neighbour);
                }
                Node deepCopyNode = hashmap.get(current); // get new deep node 
                Node deepCopyNeighbour = hashmap.get(neighbour);
                deepCopyNode.neighbors.add(deepCopyNeighbour);
            }
        }
        return hashmap.get(node);
    }
}
