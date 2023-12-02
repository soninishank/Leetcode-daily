class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int arr : nums) {
            hashmap.put(arr, hashmap.getOrDefault(arr, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (hashmap.get(a) - hashmap.get(b)));
        pq.addAll(hashmap.keySet());
        while(pq.size() > k){
            pq.poll();
        }
        int[] arr = new int[pq.size()];
        while(pq.size() > 0){
            arr[k-1] = pq.poll();
            k--;
        }
        return arr;
    }
}
