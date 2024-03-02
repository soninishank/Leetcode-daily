class Solution {

    public int minPathSum(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if(i == 0 && j == 0){
                    continue;
                }
                else if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0 && i > 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return grid[rowLength - 1][colLength - 1];
    }
}
