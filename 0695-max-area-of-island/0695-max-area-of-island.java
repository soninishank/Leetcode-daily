class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    int res = applyDFS(grid, i, j);
                    maxArea = Math.max(maxArea, res);
                }
            }
        }
        return maxArea;
    }

    private int applyDFS(int[][] grid, int rowNo, int colNo) {
         if (rowNo < 0 || rowNo >= grid.length || colNo < 0 || colNo >= grid[0].length || grid[rowNo][colNo] != 1) {
            return 0;
        }
        grid[rowNo][colNo] = 0;
        int count = 1;
        for (int[] d : dir) {
            count += applyDFS(grid, rowNo + d[0], colNo + d[1]);
        }
        return count;
    }
}
