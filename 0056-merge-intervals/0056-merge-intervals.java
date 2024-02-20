class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return null;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                list.add(temp);
                temp = intervals[i];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][]);
    }
}
