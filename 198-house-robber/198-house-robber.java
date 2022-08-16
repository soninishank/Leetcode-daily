class Solution {
    public int rob(int[] nums) {
       if(nums.length == 0){
           return 0;
       } 
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
       int left = findTotalSum(nums,0,dp);
        int right = findTotalSum(nums,1,dp);
        return Math.max(left,right);
    }
    
    private int findTotalSum(int[] nums,int index,int[] dp)
    {
        if(index == nums.length-1)
        {
            return nums[nums.length-1];
        }
        if(index > nums.length-1)
        {
            return 0;
        }
        if(dp[index] != -1)
        {
            return dp[index];
        }
        int left =  nums[index] + findTotalSum(nums,index+2,dp);
        int right =  nums[index] + findTotalSum(nums,index+3,dp);
        return dp[index] = Math.max(left,right);
    }
}