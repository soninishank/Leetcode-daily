class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<int[], Integer> hashmap = new HashMap<>();
        for(int[] arr: points){
            hashmap.put(arr,findEuclideanDistance(arr));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (hashmap.get(b) - hashmap.get(a)));
        pq.addAll(hashmap.keySet());
        while(pq.size() > k){
            pq.poll();
        }
        int[][] arr = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            arr[i] = pq.poll();
            i++;
        }
        return arr;
    }
    
    public int findEuclideanDistance(int[] arr){
        int x1 = arr[0]- 0;
        int x2 = arr[1] - 0;
        return x1 * x1 + x2 * x2;
    }
}