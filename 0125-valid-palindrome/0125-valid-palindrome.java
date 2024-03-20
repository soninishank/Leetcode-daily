class Solution {

    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            char l1 = s.charAt(low);
            char l2 = s.charAt(high);
            if (!Character.isLetterOrDigit(l1)) {
                low++;
            } else if (!Character.isLetterOrDigit(l2)) {
                high--;
            } else {
                if (Character.toLowerCase(l1) == Character.toLowerCase(l2)) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
