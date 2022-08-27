class Solution {
    int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.add(new int[] { i, j });
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        for (int[] way : direction) {
                            int x = way[0] + arr[0];
                            int y = way[1] + arr[1];
                            if (x >= 0 && y >= 0 && x <= grid.length - 1 && y <= grid[0].length - 1 && grid[x][y] == '1') {
                                queue.add(new int[] { x, y });
                                grid[x][y] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
