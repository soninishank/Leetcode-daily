class Solution {
    // Its very easy
    // Just think of a single character
    // single character is always palindrome
    // then take two characters - "ba"
    int finalDifference = 0;
    int start = 0;

    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            extendAroundPalindrome(s, i, i);
            extendAroundPalindrome(s, i, i + 1);
        }

        return s.substring(start, start + finalDifference);
    }

    private void extendAroundPalindrome(String str, int low, int high) {
        while (low >= 0 && high <= str.length() - 1 && str.charAt(low) == str.charAt(high)) {
            low--;
            high++;
        }
        // low = -1 , high = 1 so to get a single digit as Palindrome we need to subtract 1
        // 1 - (-1) -1 
        // 1 + 1 - 1 = 2 -1 = 1
        int diff = high - low - 1;
        if (diff > finalDifference) {
            finalDifference = diff;
            start = low + 1; // because low can be -1;
        }
    }
}
