class Solution {

    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        int currentIndex = 0;
        while (currentIndex <= high) {
            if (nums[currentIndex] == 0) {
                int temp = nums[low];
                nums[low] = nums[currentIndex];
                nums[currentIndex] = temp;
                low++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                int temp = nums[high];
                nums[high] = nums[currentIndex];
                nums[currentIndex] = temp;
                high--;
            } else {
                currentIndex++;
            }
        }
    }
}
