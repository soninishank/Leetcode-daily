class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : hashmap.keySet()) {
            int val = hashmap.get(key);
            if (list.contains(val)) {
                return false;
            }
            list.add(val);
        }
        return true;
    }
}
