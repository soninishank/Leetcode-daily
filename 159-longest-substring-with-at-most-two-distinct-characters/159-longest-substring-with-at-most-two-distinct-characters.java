class Solution {
    int count = 0;
    int[] arr = new int[256];

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int end = 0, start = 0, result = 0;
        while (end < s.length()) {
            if (arr[s.charAt(end)] == 0) {
                count++;
            }
            arr[s.charAt(end)]++;
            while (count > 2) {
                arr[s.charAt(start)]--;
                if (arr[s.charAt(start)] == 0) {
                    count--;
                }
                start++;
            }
            end++;
            result = Math.max(result, end - start);
        }
        return result;
    }
}
