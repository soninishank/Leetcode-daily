class Solution {

    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0)
        {
            return true;
        }
        for (int i = num / 2; i < num; i++) {
            if (i + getReverse(i) == num) {
                return true;
            }
        }
        return false;
    }

    private int getReverse(int num) {
        int result = 0;
        while (num > 0) {
            int remainder = num % 10;
            result = result * 10 + remainder;
            num = num / 10;
        }
        return result;
    }
}
