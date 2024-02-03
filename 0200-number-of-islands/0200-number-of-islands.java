class Solution {
    int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int row = 0;
    int col = 0;
    int count = 0;

    public int numIslands(char[][] grid) {
        row = grid.length - 1;
        col = grid[0].length - 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    applyDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void applyDFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        applyDFS(grid, i + 1, j);
        applyDFS(grid, i - 1, j);
        applyDFS(grid, i, j - 1);
        applyDFS(grid, i, j + 1);
        return;
    }
}
