class Solution {
   public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(rows, k); i++) {
            priorityQueue.add(new int[]{matrix[i][0], i, 0});
        }
        int result = -1;
        for (int i = 0; i < k; i++) {
            int[] temp = priorityQueue.poll();
            result = temp[0];
            int rowNo = temp[1], colNo = temp[2];

            if (colNo + 1 < cols) {
                priorityQueue.add(new int[]{matrix[rowNo][colNo + 1], rowNo, colNo + 1});
            }
        }
        return result;
    }

}