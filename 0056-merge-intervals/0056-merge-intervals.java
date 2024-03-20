class Solution {

    public int[][] merge(int[][] intervals) {
        // Base case
        if (intervals.length == 0) {
            return null;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                currentInterval[0] = Math.min(currentInterval[0], intervals[i][0]);
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                list.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        list.add(currentInterval);
        return list.toArray(new int[list.size()][]);
    }
}
