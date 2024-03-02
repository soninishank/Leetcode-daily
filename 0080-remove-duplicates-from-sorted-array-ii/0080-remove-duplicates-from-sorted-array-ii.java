class Solution {

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int val : nums) {
            if (count < 2 || nums[count - 2] < val) {
                nums[count] = val;
                count++;
            }
        }
        return count;
    }
}
