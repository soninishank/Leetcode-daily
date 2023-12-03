class Solution {

    public int lengthOfLongestSubstring(String s) {
        int end = 0, start = 0, length = s.length();
        int result = 0;
        int[] arr = new int[256];
        while (end < length) {
            char c1 = s.charAt(end);
            arr[c1]++;
            end++;
            while (arr[c1] > 1) {
                char c2 = s.charAt(start);
                arr[c2]--;
                start++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}
