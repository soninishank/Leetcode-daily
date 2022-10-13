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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        temp = dummy;

        int diff = size - n;
        if (diff == 0) {
            return temp.next.next;
        }
        while (temp != null && diff != 0) {
            temp = temp.next;
            diff--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
