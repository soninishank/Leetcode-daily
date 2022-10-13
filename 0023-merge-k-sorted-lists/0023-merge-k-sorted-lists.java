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
// https://stackoverflow.com/questions/2555284/java-priority-queue-with-a-custom-anonymous-comparator
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((listNode1, listNode2) -> Integer.compare(listNode1.val, listNode2.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            ListNode newNode = new ListNode(poll.val);
            temp.next = newNode;
            temp = temp.next;
            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }
}

 // public int[] mergekSortedArrays(int[][] arrays) {
 //        int result = 0;
 //        PriorityQueue<RowIndex> priorityQueue = new PriorityQueue<>((rowIndex1, rowIndex2) -> rowIndex1.value - rowIndex2.value);
 //        for (int i = 0; i < arrays.length; i++) {
 //            result += arrays[i].length;
 //            priorityQueue.add(new RowIndex(i, 0, arrays[i][0]));
 //        }
 //        int[] finalArray = new int[result];
 //        int i = 0;
 //        while (!priorityQueue.isEmpty()) {
 //            RowIndex poll = priorityQueue.poll();
 //            finalArray[i] = poll.value;
 //            i++;
 //            if (poll.index + 1 < arrays[poll.rowNo].length) {
 //                priorityQueue.add(new RowIndex(poll.rowNo, poll.index + 1, arrays[poll.rowNo][poll.index + 1]));
 //            }
 //        }
 //        return finalArray;
 //    }
