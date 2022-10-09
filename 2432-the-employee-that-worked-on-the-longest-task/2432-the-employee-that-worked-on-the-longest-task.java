class Solution {

    public int hardestWorker(int n, int[][] logs) {
        int startTime = 0;
        int timeTaken = 0;
        int empId = -1;
        for (int i = 0; i < logs.length; i++) {
            int diff = logs[i][1] - startTime;
            if (diff > timeTaken) {
                timeTaken = diff;
                empId = logs[i][0];
            } else if (diff == timeTaken && logs[i][0] < empId) {
                empId = logs[i][0];
            }
            startTime = logs[i][1];
        }
        return empId;
    }
}
