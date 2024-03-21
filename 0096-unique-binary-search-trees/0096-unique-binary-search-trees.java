class Solution {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return solve(1, n);
    }

    private int solve(int start, int end) {
        int count = 0;
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int leftCount = solve(start, i - 1);
            int rightCount = solve(i + 1, end);

            count += leftCount * rightCount; // for loop is same as multiplication
        }
        return count;
    }
}
