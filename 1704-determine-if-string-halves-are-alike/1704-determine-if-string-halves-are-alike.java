class Solution {

    public boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.toLowerCase().charAt(i);
            if (i < s.length() / 2 && isVowel(c1)) {
                count1++;
            } else if (i >= s.length() / 2 && isVowel(c1)) {
                count2++;
            }
        }
        return count1 == count2;
    }

    private boolean isVowel(char c1) {
        if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
            return true;
        }
        return false;
    }
}
