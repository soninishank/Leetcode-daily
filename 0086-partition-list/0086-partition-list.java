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

    public ListNode partition(ListNode head, int x) {
        ListNode smallerList = new ListNode(-1);
        ListNode small = smallerList;
        ListNode largerList = new ListNode(-1);
        ListNode larger = largerList;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }
        larger.next = null;
        small.next = largerList.next;
        return smallerList.next;
    }
}
