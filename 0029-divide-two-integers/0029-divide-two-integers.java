class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        // Both positive
        if(dividend > 0 && divisor > 0){
            sign = 1;
        }else if(dividend < 0 && divisor < 0){
            sign=1;
        }
        else{
            sign = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        
        while(dividend - divisor >= 0){
            int temp = divisor;
            int count = 1;
            while(dividend - (temp << 1) >= 0){
                temp = temp<<1;
                count = count<<1;
            }
            result += count;
            dividend -= temp;
        }
        return result * sign;
    }
}