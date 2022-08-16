class Solution {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int first = applyDP(cost, 0, dp);
        int second = applyDP(cost, 1, dp);
        return Math.min(first, second);
    }

    private int applyDP(int[] cost, int index, int[] dp) {
        if (index == cost.length - 1) {
            return cost[cost.length - 1];
        }
        if (index > cost.length - 1) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int left = cost[index] + applyDP(cost, index + 1, dp);
        int right = cost[index] + applyDP(cost, index + 2, dp);
        return dp[index] = Math.min(left, right);
    }
}
