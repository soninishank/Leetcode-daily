class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int m1 : nums1) {
            for (int n1 : nums2) {
                int sum = m1 + n1;
                hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        HashMap<Integer, Integer> hashmap1 = new HashMap<>();
        for (int m11 : nums3) {
            for (int n11 : nums4) {
                int sum = -(m11 + n11);
                count += hashmap.getOrDefault(sum,0);
            }
        }
        return count;
    }
}
