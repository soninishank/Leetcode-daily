class Solution {
    public void rotate(int[] nums, int k) {
       k = k % nums.length;
       reverseNum(nums,0,nums.length-1);
        reverseNum(nums,0,k-1);
        reverseNum(nums,k,nums.length-1);
    }
    
    
    void reverseNum(int[] nums,int low, int high){
        while(low <= high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
    
}