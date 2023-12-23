class Solution {
    public boolean isPalindrome(String s) {
          int low = 0, high = s.length() - 1;
        while (low <= high) {
            char head = s.charAt(low);
            char tail = s.charAt(high);
            if (!Character.isLetterOrDigit(head)) {
                low++;
            } else if (!Character.isLetterOrDigit(tail)) {
                high--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                low++;
                high--;
            }
        }
        return true;
    }
}