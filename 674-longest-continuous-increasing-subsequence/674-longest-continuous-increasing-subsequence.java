class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max_so_far = 1, current_so_far = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1])
            {
               current_so_far++; 
            }else
            {
                current_so_far = 1;
            }
            max_so_far = Math.max(max_so_far,current_so_far);
        }
        return max_so_far;
    }
}
