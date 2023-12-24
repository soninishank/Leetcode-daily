class Solution {

    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length + nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        int i = nums.length;
        for (int j = 0; j < nums.length ; j++) {
            res[i] = nums[j];
            i++;
        }
        return res;
    }
}
