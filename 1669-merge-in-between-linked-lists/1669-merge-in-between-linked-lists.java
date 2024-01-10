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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode original = new ListNode(-1);
        ListNode dummy = original;

        int index = 0;
        while (list1 != null) {
            if (index != a) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
                index++;
            } else {
                while (list2 != null) {
                    dummy.next = list2;
                    list2 = list2.next;
                    dummy = dummy.next;
                }
                while(index <= b){
                    index++;
                    list1 = list1.next;
                }
            }
        }
        return original.next;
    }
}
