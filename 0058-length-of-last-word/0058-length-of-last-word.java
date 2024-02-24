class Solution {
    int count = 0;

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] words = s.split("\\s+");
        return words[words.length - 1].length();
    }
}
