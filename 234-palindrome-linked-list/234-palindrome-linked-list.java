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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstHalfEnd = endFirstHalf(head);
        ListNode reverseSecondHalfList = reverseSecondHalf(firstHalfEnd.next);

        // Now we compare both the above ListNode
        ListNode headA = head; // because the pointer of firstHalfEnd is at end of mid
        ListNode headB = reverseSecondHalfList;
        boolean result = true; // we are taking this variable bcz we can return this in last
        while (headA != null && headB != null) {
            if (headA.val != headB.val) {
                result = false;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        // Now restore the original list
        firstHalfEnd.next = reverseSecondHalf(reverseSecondHalfList);
        return result;
    }

    // using two pointers - similar like middle element
    // if odd number than middle node will be attached to the first half
    private ListNode endFirstHalf(ListNode head) {
       ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // reverse second half
    private ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // store current next position
            curr.next = prev; // point current next to prev pointer

            prev = curr; // take prev to current position
            curr = next; // move current to next
        }
        return prev;
    }
}
