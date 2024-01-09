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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        ListNode temp = head;
        while(temp != null){
            pq.add(temp.val);
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode sorted = dummy;
        
        while(!pq.isEmpty()){
            int val = pq.poll();
            sorted.next = new ListNode(val); // Jab bhi intialize karo always use next 
            sorted = sorted.next;
        }
        return dummy.next;
    }
}