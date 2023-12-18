class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int end = 0,start = 0 ;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while(end < nums.length){
            sum += nums[end];
            end++;
            while (sum >= target) {
                length = Math.min(length, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return length != Integer.MAX_VALUE ? length : 0;
    }
}