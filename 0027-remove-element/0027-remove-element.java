class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int length = nums.length - 1;
        while (i <= length) {
            if(nums[i] == val){
                nums[i] = nums[length];
                nums[length] = val;
                length--;
            }else{
                i++;
            }
        }
        return i;
    }
}
