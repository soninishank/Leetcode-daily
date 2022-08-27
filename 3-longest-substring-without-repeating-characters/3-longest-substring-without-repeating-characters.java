class Solution {

// Time complexity : O(2n) = O(n)O(2n)=O(n). In the worst case each character will be visited twice by ii and jj.
// Space complexity : O(min(m, n))O(min(m,n)). Same as the previous approach. We need O(k) space for the sliding window, where k is the size of the Set. The size of the Set is upper bounded by the size of the string nn and the size of the charset/alphabet mm.
    
    
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