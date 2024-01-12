class Solution {

    public boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            char c1 = s.toLowerCase().charAt(i);
            if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                count1++;
            }
        }
        for (int j = s.length() / 2; j < s.length(); j++) {
            char c2 = s.toLowerCase().charAt(j);
            if (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') {
                count2++;
            }
        }

        return count1 == count2;
    }
}
