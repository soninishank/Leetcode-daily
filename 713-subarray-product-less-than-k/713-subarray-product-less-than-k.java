class Solution {
    // less than k 
    // sliding window
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)
        {
            return 0;
        }
        int end = 0 , start = 0 ;
        int result = 0;
        int product = 1;
        while(end < nums.length)
        {
            product *= nums[end];
            end++;
            while(product >= k)
            {
                product /= nums[start];
                start++;
            }
            result += end-start;
        }
        return result;
    }
}