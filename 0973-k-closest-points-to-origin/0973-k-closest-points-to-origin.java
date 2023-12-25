class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getEuclideanDistance(b) - getEuclideanDistance(a));
        for (int point[] : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] arr = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            arr[i] = pq.poll();
            i++;
        }
        return arr;
    }

    private int getEuclideanDistance(int[] point) {
        int first = point[0] - 0;
        int second = point[1] - 0;
        return first * first + second * second;
    }
}
