class Solution {

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return checkPalindrome(s, low + 1, high) || checkPalindrome(s, low, high - 1);
            }
        }
        return true;
    }

    private boolean checkPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }
}
