class Solution {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num % mid == 0 && mid == num / mid) {
                return true;
            } else if (mid < num / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
