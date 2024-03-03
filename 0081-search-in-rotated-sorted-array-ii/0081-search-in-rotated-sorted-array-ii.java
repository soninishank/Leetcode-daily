class Solution {
    public boolean search(int[] nums, int target) {
     int pivotIndex = findMin(nums);
        int rightSide = BinarySearch(nums, pivotIndex, nums.length - 1, target);
        if (rightSide != -1) {
            return true;
        }
        int leftSide = BinarySearch(nums, 0, pivotIndex - 1, target);
        if (leftSide != -1) {
            return true;
        }
        return false;
    }

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] == nums[low + 1]) {
                low = low + 1;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high = high - 1;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1; // it means minimum element is on right side
            } else {
                high = mid; // it might be possible that mid is my minimum element and you don't want to lose it
            }
        }
        return high;
    }

    public int BinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}