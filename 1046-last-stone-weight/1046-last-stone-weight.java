class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int a : stones) {
            pq.add(a);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                int res = Math.abs(a) - Math.abs(b);
                pq.add(res);
            }
        }
        if(pq.size() == 0){
            return 0;
        }
        return pq.poll();
    }
}
