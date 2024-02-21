class Solution {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += checkPalindrome(s, i, i);
            count += checkPalindrome(s, i, i + 1);
        }
        return count;
    }

    // we are passing complete string
    // and just checking through index
    private int checkPalindrome(String s, int low, int high) {
        int count = 0;
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
