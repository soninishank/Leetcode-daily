//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
     public boolean is_Possible(int[][] grid) {
        // Code here
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        boolean[][] visited = new boolean[totalRows][totalCols];
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (grid[i][j] == 1) {
                    boolean val = applyDFS(i, j, grid, totalRows, totalCols, visited);
                    return val;
                }
            }
        }
        return false;
    }

    private boolean applyDFS(int sourceRow, int sourceCol, int[][] grid, int totalRows, int totalCols, boolean[][] visited) {
        if (sourceRow < 0 || sourceCol < 0 || sourceRow > totalRows - 1 || sourceCol > totalCols - 1 || grid[sourceRow][sourceCol] == 0 || (visited[sourceRow][sourceCol] == true)) {
            return false;
        }
        if (grid[sourceRow][sourceCol] == 2) {
            return true;
        }
        visited[sourceRow][sourceCol] = true;
        boolean a = applyDFS(sourceRow + 1, sourceCol, grid, totalRows, totalCols, visited);
        boolean b = applyDFS(sourceRow - 1, sourceCol, grid, totalRows, totalCols, visited);
        boolean c = applyDFS(sourceRow, sourceCol + 1, grid, totalRows, totalCols, visited);
        boolean d = applyDFS(sourceRow, sourceCol - 1, grid, totalRows, totalCols, visited);
        return a || b || c || d;
    }
}