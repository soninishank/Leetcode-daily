class Solution {
    int count = 0;

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] > intervals[i][0]) {
                count++;
            } else {
                temp = intervals[i];
            }
        }
        return count;
    }
}
