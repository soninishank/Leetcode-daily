class Solution {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            int rem = n % 3;
            if(rem != 0)
            {
                return false;
            }
            n = n / 3;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}
