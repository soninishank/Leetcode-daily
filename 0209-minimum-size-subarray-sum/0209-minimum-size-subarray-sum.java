class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int end = 0 , start = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        while(end < nums.length){
            currentSum += nums[end];
            end++;
            while(currentSum >= target){
                minLength = Math.min(minLength,end-start);
                currentSum -= nums[start];
                start++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}