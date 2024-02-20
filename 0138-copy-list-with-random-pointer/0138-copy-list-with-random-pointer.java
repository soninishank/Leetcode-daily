/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashmap = new HashMap<>();
        Node currentHead = head;

        while (currentHead != null) {
            hashmap.put(currentHead, new Node(currentHead.val));
            currentHead = currentHead.next;
        }

        currentHead = head;
        while (currentHead != null) {
            hashmap.get(currentHead).next = hashmap.get(currentHead.next);
            hashmap.get(currentHead).random = hashmap.get(currentHead.random);
            currentHead = currentHead.next;
        }
        return hashmap.get(head);
    }
}
