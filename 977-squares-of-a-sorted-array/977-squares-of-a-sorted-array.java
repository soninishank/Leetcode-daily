class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            if (Math.abs(nums[low]) < Math.abs(nums[high])) {
                result[index] = nums[high] * nums[high];
                high--;
            } else {
                result[index] = nums[low] * nums[low];
                low++;
            }
            index--;
        }
        return result;
    }
}
