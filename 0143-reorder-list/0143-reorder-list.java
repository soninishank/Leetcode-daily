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

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode middle = middleNode(head);
        ListNode reverseData = reverseList(middle);
        mergeData(head, reverseData);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current; // move prev to next position

            current = next; // move current by one step
        }
        return prev;
    }

    public void mergeData(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (head1 != null && head2 != null) {
            current.next = head1;
            head1 = head1.next;
            current = current.next;

            current.next = head2;
            head2 = head2.next;
            current = current.next;
        }

        // Attach any remaining nodes from head1 or head2
        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        current.next = null;
        head1 = dummy.next;
    }
}
// Find mid
// reverse after mid
// merge original + reversed mid
