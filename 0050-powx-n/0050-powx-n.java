class Solution {
    public double myPow(double x, long n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            x = 1/x;
            n = -n;
        }
        if(n % 2 == 0){
            return myPow(x * x , n /2);
        }else{
            return x * myPow(x * x , n /2);
        }
    }
}