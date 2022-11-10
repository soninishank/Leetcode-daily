class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            // store not more than k elements - remove start elements
            while (!deque.isEmpty() && i - deque.getFirst() > k - 1) {
                deque.pollFirst();
            }
            // store only max elements
            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                result.add(arr[deque.getFirst()]);
            }
        }
        int[] example1 = result.stream().mapToInt(i->i).toArray();
        return example1;
    }
}