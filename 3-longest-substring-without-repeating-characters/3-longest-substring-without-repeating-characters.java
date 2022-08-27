class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int end = 0 , start = 0;
        int result = 0;
        while(end < s.length())
        {
            arr[s.charAt(end)]++;
            while(arr[s.charAt(end)] > 1)
            {
                arr[s.charAt(start)]--;
                start++;
            }
            end++;
            result = Math.max(result,end-start);
        }
        return result;
    }
}