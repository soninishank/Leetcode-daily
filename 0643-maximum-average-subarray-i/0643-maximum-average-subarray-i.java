class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int end = 0;
        int start = 0;
        double maxValue = Double.NEGATIVE_INFINITY; // Update: Initialize maxValue to negative infinity

        double runningSum = 0;
        while (end < nums.length) {
            runningSum += nums[end];
            end++;

            if (end - start >= k) {
                double average = runningSum / k;
                maxValue = Math.max(average, maxValue);
                runningSum -= nums[start];
                start++;
            }
        }
        return maxValue;
    }
}
