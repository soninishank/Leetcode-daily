class Solution {

    public String frequencySort(String nums) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (char arr : nums.toCharArray()) {
            hashmap.put(arr, hashmap.getOrDefault(arr, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (hashmap.get(b) - hashmap.get(a)));
        pq.addAll(hashmap.keySet());
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char ch = pq.poll();
            int val = hashmap.get(ch);
            for (int i = 0; i < val; i++) {
             sb.append(ch);   
            }
        }
        return sb.toString();
    }
}
