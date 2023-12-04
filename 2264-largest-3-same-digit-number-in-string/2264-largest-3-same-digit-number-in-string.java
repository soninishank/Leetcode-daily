class Solution {

    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            String substr = num.substring(i, i + 2 + 1);
            if (checkUnique(substr)) {
                if (substr.compareTo(res) > 0) {
                    res = substr;
                }
            }
        }
        return res;
    }
    
    private boolean checkUnique(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
