/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((listNode1, listNode2) -> Integer.compare(listNode1.val, listNode2.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            ListNode newNode = new ListNode(poll.val);
            temp.next = newNode;
            temp = temp.next;
            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }
}
