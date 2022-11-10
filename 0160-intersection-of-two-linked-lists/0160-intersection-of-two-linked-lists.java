/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode a = head1;
        ListNode b = head2;
        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = head2;
            }
            if (b != null) {
                b = b.next;
            } else {
                b = head1;
            }
        }
        return b;
    }
}
