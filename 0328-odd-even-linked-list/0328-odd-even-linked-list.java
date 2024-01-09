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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddDummy = new ListNode(-1);
        ListNode odd = oddDummy;

        ListNode evenDummy = new ListNode(-1);
        ListNode even = evenDummy;

        int count = 1;
        while (head != null) {
            if (count % 2 != 0) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            count++;
        }
        even.next = null; // Terminate the even list
        odd.next = evenDummy.next; // Connect odd list with even list

        return oddDummy.next; 
    }
}
