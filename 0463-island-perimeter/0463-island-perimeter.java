class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    for(int[] direction : dir){
                        int x = direction[0] + i;
                        int y = direction[1] + j;
                        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}