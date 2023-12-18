class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int low = 2 , high = x;
        while(low <= high){
            int mid = low + (high - low)/2;
            long sum = (long) mid * mid;
            if(sum == x){
                return mid;
            }else if (sum > x){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}