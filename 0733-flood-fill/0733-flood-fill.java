class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        HashSet<int[]> visited = new HashSet<>();
        int currentColor = image[sr][sc];
         if (currentColor == newColor){
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        visited.add(new int[] { sr, sc });
        queue.add(new int[] { sr, sc });
        while (!queue.isEmpty()) {
            int arr[] = queue.poll();
            int x = arr[0];
            int y = arr[1];
            image[x][y] = newColor;
            for (int[] val : dir) {
                int row = x + val[0];
                int col = y + val[1];
                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length && !visited.contains(new int[] { sr, sc })) {
                    if (image[row][col] == currentColor) {
                        queue.add(new int[] { row, col });
                        visited.add(new int[] { row, col });
                    }
                }
            }
        }
        return image;
    }
}
