class Solution {

    public int longestOnes(int[] nums, int k) {
        int end = 0, start = 0;
        int totalLength = 0;
        int changeAllowed = k;
        while (end < nums.length) {
            if (nums[end] == 0) {
                changeAllowed--;
            }
            end++;
            while (changeAllowed < 0) {
                if (nums[start] == 0) {
                    changeAllowed++;
                }
                start++;
            }
            totalLength = Math.max(totalLength, end - start);
        }
        return totalLength;
    }
}
