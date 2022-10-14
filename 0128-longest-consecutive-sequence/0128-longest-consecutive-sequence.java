class Solution {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        HashSet<Integer> hashmap = new HashSet<>();
        int max = Integer.MIN_VALUE;
         for (int i = 0; i < nums.length; i++) {
            hashmap.add(nums[i]);
        }
        for (int arr : nums) {
            if(hashmap.contains(arr-1))
            {
                continue;
            }else
            {
                int value = 1;
                while(hashmap.contains(arr+value))
                {
                    value++;
                }
                max = Math.max(max,value);
            }
        }
        return max;
    }
}
