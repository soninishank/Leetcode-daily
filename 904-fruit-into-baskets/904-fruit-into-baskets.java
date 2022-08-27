class Solution {

    public int totalFruit(int[] arr) {
        int k = 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int end = 0, start = 0;
        int count = 0, result = 0;
        while (end < arr.length) {
            if (hashMap.get(arr[end]) == null) {
                count++;
            }
            hashMap.put(arr[end], hashMap.getOrDefault(arr[end], 0) + 1);
            while (count > k) {
                hashMap.put(arr[start], hashMap.getOrDefault(arr[start], 0) - 1);
                if (hashMap.get(arr[start]) <= 0) {
                    count--;
                    hashMap.remove(arr[start]);
                }
                start++;
            }
            end++;
            result = Math.max(result, end - start);
        }
        return result;
    }
}
