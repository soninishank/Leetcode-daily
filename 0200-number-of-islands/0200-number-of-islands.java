class Solution {
    public int numIslands(char[][] grid) {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited.contains(i + "-" + j) || grid[i][j] == '0') {
                    continue;
                }
                count++;
                queue.add(new int[]{i, j});
                visited.add(i + "-" + j);
                while (!queue.isEmpty()) {
                    int[] arr = queue.poll();
                    for (int[] direction : dir) {
                        int x = arr[0] + direction[0];
                        int y = arr[1] + direction[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited.contains(x + "-" + y)) {
                            queue.add(new int[]{x, y});
                            visited.add(x + "-" + y);
                        }
                    }
                }
            }
        }
        return count;
    }
}