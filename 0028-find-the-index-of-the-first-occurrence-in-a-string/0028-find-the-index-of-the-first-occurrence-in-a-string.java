class Solution {
    public int strStr(String haystack, String needle) {
         int length = needle.length();
        for (int i = 0; i <= haystack.length() - length; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}