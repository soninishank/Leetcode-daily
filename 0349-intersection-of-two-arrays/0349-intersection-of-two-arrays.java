class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> finalSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                finalSet.add(nums2[i]);
            }
        }
        int[] result = new int[finalSet.size()];
        int index = 0;
        for (int num : finalSet) {
            result[index++] = num;
        }

        return result;
    }
}
