class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    HashSet<int[]> visited = new HashSet<>();
    int count = 0;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;
        int rottenOrange = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }
         if (freshOrange == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pollItem = queue.poll();
                visited.add(pollItem);
                for (int[] arr : dir) {
                    int x = arr[0] + pollItem[0];
                    int y = arr[1] + pollItem[1];
                    if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || visited.contains(new int[]{x,y}) || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    freshOrange--;
                    queue.add(new int[] { x, y });
                    grid[x][y] = 2;
                }
            }
            count++;
        }
       return freshOrange == 0 ? count - 1 : -1;
    }
}
// 0 - empty cell
// 1 - fresh orange
// 2 - rotten orange
