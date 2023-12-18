class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int end = 0, start = 0;
        int result = Integer.MIN_VALUE;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            arr[c1]++;
            end++;
            while (arr[c1] > 1) {
                char c2 = s.charAt(start);
                arr[c2]--;
                start++;
            }
            if (end - start > result) {
                result = end - start;
            }
        }
        if (result == Integer.MIN_VALUE) {
            return 0;
        }
        return result;
    }
}
