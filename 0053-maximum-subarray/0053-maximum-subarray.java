class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            runningSum += nums[i];
            maxValue = Math.max(runningSum,maxValue);
            if(runningSum < 0)
            {
                runningSum = 0;
            }
        }
        return maxValue;
    }
}