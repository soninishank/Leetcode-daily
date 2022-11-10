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
        ListNode temp = head;
        ListNode mid = findMid(temp);
        ListNode rev = reverseLL(mid);
        while (temp != null && rev != null) {
            if (temp.val != rev.val) {
                return false;
            }
            rev = rev.next;
            temp = temp.next;
        }
        return true;
    }

    private ListNode reverseLL(ListNode temp)
    {
        ListNode current = temp;
        ListNode prev = null;
        while(current != null)
        {
             ListNode next = current.next;
             current.next = prev;
             prev = current;
             current = next;
        }
        return prev;
    }
    
    
    private ListNode findMid(ListNode temp) {
        if (temp == null) {
            return null;
        }
        ListNode slow = temp;
        ListNode fast = temp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}