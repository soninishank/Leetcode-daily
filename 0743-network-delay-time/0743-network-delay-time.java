class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr : times) {
            list.get(arr[0]).add(new int[]{arr[1],arr[2]});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int totalCost = 0;
        pq.add(new int[] { k, 0 });
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] arr1 = pq.poll();
                if (visited.contains(arr1[0])) {
                    continue;
                }
                visited.add(arr1[0]);
                totalCost = Math.max(totalCost, arr1[1]);
                if (visited.size() == n) {
                    return totalCost;
                }
                for (int[] child : list.get(arr1[0])) {
                    pq.add(new int[] { child[0], arr1[1] + child[1] });
                }
            }
        }
        return -1;
    }
}
