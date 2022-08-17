class Solution {
     public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        // fill column
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        // fill the row
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        // fill initial data
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    if (dp[i][j - 1] >= 1 && dp[i - 1][j] >= 1 && dp[i - 1][j - 1] >= 1) {
                        int minValue = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                        dp[i][j] = minValue;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }
}