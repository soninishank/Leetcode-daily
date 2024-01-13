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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode predecessor = dummy;

        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                predecessor.next = head.next; // major thing
                head = head.next;
            } else {// basic
                predecessor.next = head;
                predecessor = predecessor.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
