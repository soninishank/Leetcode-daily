class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int leftSide = applyBinarySearchLeftSide(nums, target);
        int rightSide = applyBinarySearchRightSide(nums, target);
        if (leftSide != -1 && rightSide != -1) {
            return new int[] { leftSide, rightSide };
        }
        return new int[] { -1, -1 };
    }

    private int applyBinarySearchLeftSide(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int leftMost = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                leftMost = mid;
                high = mid - 1; // because i want to go on lower side
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return leftMost;
    }

    private int applyBinarySearchRightSide(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int rightMost = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                rightMost = mid;
                low = mid + 1; // because i want to go on lower side
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return rightMost;
    }
}
