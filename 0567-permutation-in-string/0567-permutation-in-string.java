class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--; // negative done
        }
        
        // what if only both are of same length 
        if (isAllZeroes(count)) {
            return true;
        }

        // so in this start with positive and make sure that window size is s1.length
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--; // repeat negative

            // now we need do squeeze the window
            int diff = i - s1.length();
            count[s2.charAt(diff) - 'a']++; // positive karo

            if (isAllZeroes(count)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllZeroes(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
