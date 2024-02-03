class Solution {

    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            builder.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
