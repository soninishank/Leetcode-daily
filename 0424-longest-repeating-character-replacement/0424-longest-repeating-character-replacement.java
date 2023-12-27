class Solution {
    public int characterReplacement(String s, int k) {
        int[] cArr = new int[26];
        int maxFreq = 0, start = 0, maxSize = 0;
        int end = 0;
        while (end < s.length()) {
            int index = s.charAt(end) - 'A';// uppercase letters hai 
            cArr[index]++;
            maxFreq = Math.max(maxFreq, cArr[index]);
            end++;
            if (end - start > k + maxFreq) {
                cArr[s.charAt(start) - 'A']--;
                start++;
            }
            maxSize = Math.max(maxSize, end - start);
        }
        return maxSize;
    }
}


// AABABBA  k = 1

// A     maxFreq = 1   end = 1
// AA    maxFreq = 2   end = 2
// AAB   maxFreq = 2   end = 3 
// AABA  maxFreq = 3   end = 4
// AABAB  maxFreq = 3   end = 5 start = 0

// 5 - 0 > 3 + 1