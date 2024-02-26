class Solution {

    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int maxLength = 0;
        while (end < nums.length) {
            int val = nums[end];
            if (val == 0) {
                k--;
            }
            end++;
            while (k < 0) {
                int intial = nums[start];
                if (nums[start] == 0) {
                    k++;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}
