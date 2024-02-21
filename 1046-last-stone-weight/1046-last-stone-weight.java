class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first == second) {
                continue;
            } else {
                int val = Math.abs(first) - Math.abs(second);
                pq.add(val);
            }
        }
        if (pq.size() == 0) {
            return 0;
        }
        return pq.poll();
    }
}
