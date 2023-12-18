class Solution {

    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int arr : nums) {
            maxPq.add(arr);
        }
        int res1 = 1;
        res1 = maxPq.poll() * maxPq.poll();
        while (!maxPq.isEmpty() && maxPq.size() > 2) {
            maxPq.poll();
        }
        int res2 = maxPq.poll() * maxPq.poll();
        return res1 - res2;
    }
}
