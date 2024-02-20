class Solution {

    public int maximalSquare(char[][] matrix) {
        int maxValue = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    maxValue = Math.max(maxValue, dp[i][j]);
                }
            }
        }
        return maxValue * maxValue;
    }

}