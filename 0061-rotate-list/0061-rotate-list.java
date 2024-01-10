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
// It is very easy 
// 1. count the length - https://leetcode.com/problems/rotate-array
// 2. find modulo
// 3. its not about reverse , its about connecting 
// 4. firstPart -> length -k 
// 5. secondPart -> k to totalLength
// 6. Join secondPart.next with firstPart start
class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int length = countLength(temp);
        k = k % length;
        temp = head;
        ListNode firstPartDummy = new ListNode(-1);
        ListNode firstPart = firstPartDummy;
        for(int i = 0; i < length - k ; i++){
            firstPart.next = temp;
            temp = temp.next;
            firstPart = firstPart.next;
        }
        firstPart.next = null;
        ListNode secondPartDummy = new ListNode(-1);
        ListNode secondPart = secondPartDummy;
        while(temp != null){
           secondPart.next = temp;
           temp = temp.next;
           secondPart = secondPart.next;
        }
        secondPart.next = firstPartDummy.next;
        return secondPartDummy.next;
    }

    private int countLength(ListNode temp) {
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
