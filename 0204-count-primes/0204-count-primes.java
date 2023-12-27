class Solution {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        boolean arr[] = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < n; i++) {
            if (arr[i] == true) {
                count++;
                for (int j = 2; i * j <= n; j++) {
                    arr[i * j] = false;
                }
            }
        }
        return count;
    }
}
