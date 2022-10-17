class Solution {

    public int findMaxK(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            hashset.add(val);
        }
        for (int val : nums) {
            if (hashset.contains(-val) && val > max) {
                max = val;
            }
        }
        if (max == Integer.MIN_VALUE) {
            return -1;
        }
        return max;
    }
}
