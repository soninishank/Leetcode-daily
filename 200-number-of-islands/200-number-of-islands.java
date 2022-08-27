class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int count = 0;
        char islandColor = '1';
        char maskColor = '*';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == islandColor) {
                    count++;
                    applyDfs(i, j, grid, islandColor, maskColor);
                }
            }
        }
        return count;
    }

    private void applyDfs(int row, int col, char[][] grid, char islandColor, char maskColor) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == islandColor) {
            grid[row][col] = maskColor;
            applyDfs(row, col - 1, grid, islandColor, maskColor);
            applyDfs(row, col + 1, grid, islandColor, maskColor);
            applyDfs(row - 1, col, grid, islandColor, maskColor);
            applyDfs(row + 1, col, grid, islandColor, maskColor);
        } else {
            return;
        }
    }
}
