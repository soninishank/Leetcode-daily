class Solution {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[totalSum / 2 + 1][nums.length + 1];
        return applyRecursion(nums, totalSum / 2, nums.length - 1, dp);
    }

    boolean applyRecursion(int[] nums, int totalSum, int index, Boolean[][] dp) {
        if (totalSum == 0) {
            return true;
        }
        if (totalSum < 0 || index < 0) {
            return false;
        }
        if (dp[totalSum][index] != null) {
            return dp[totalSum][index];
        }
        dp[totalSum][index] = applyRecursion(nums, totalSum - nums[index], index - 1, dp) || applyRecursion(nums, totalSum, index - 1, dp);
        return dp[totalSum][index];
    }
}
// 1,5,11,5
//                          f(11,3)
//          f(6,2)                          f(11,2)
//     f(-ve,)    f(6,1)                       f(0,1)                f(11,1)
//          f(1,0)  f(6,0)                  f(-1)   f(0,0)          f(6,0)  f(11,0)
// recusive sol :
// depth : totalLength
// 2^depth -> 2^n
// No of unique subproblems * work done in each step
// O(m * n ) -> dp array
