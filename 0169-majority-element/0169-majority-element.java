class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : hashmap.keySet()) {
            int val = hashmap.get(key);
            if (val > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }
}
