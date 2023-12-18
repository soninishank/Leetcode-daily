import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 4) {
            return result; // Not enough elements in the array to form a quadruplet
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate values of the first element
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicate values of the second element
                }
                
                int low = j + 1, high = nums.length - 1;
                
                while (low < high) {
                    long sum = (long) nums[i] + nums[j] + nums[low] + nums[high];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        
                        // Skip duplicate values of the third element
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        
                        // Skip duplicate values of the fourth element
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        
        return result;
    }
}
