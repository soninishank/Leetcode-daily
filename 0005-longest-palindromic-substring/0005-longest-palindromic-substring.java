class Solution {
    int finalDifference = 0;
    int start = 0;

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            findLength(s, i, i);
            findLength(s, i, i + 1);
        }
        return s.substring(start,start+finalDifference);
    }

    private void findLength(String str, int low, int high) {
        while (low >= 0 && high < str.length()) {
            if (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            } else {
                break;
            }
        }
        int diff = high - low - 1;
        if (diff > finalDifference) {
            finalDifference = diff;
            start = low + 1; // because low can be -1;
        }
    }
}
