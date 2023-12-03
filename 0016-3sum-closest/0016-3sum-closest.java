class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int totalSum = nums[low] + nums[i] + nums[high];
                if (Math.abs(target - totalSum) < Math.abs(target - closestSum)) {
                    closestSum = totalSum;
                }
                if (totalSum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return closestSum;
    }
}
