class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        
        int left = binarySearch(nums, target, true);
        if(left == -1){
            return new int[]{-1, -1};
        }
        
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }
    
    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0, high = nums.length - 1;
        int result = -1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                result = mid;
                if(isLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}
