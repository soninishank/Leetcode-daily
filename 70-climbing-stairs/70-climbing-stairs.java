class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbTree(0, n,dp);
    }

    private int climbTree(int i, int num,int[] dp) {
        if (i > num) {
            return 0;
        }
        if (i == num) {
            return 1;
        }
        if(dp[i] != -1)
        {
            return dp[i];
        }
        int left = climbTree(i + 1, num,dp);
        int right = climbTree(i + 2, num,dp);
        dp[i] = left + right;
        return dp[i];
    }
}
