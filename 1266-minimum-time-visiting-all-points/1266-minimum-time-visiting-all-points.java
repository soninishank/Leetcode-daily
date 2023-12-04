class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalDistance = 0;
        for(int i = 1 ; i < points.length; i++){
            int first[] = points[i];
            int second[] = points[i-1];
            int distance = Math.max(Math.abs(second[0]-first[0]) , Math.abs(second[1]-first[1]));
            totalDistance += distance;
        }
        return totalDistance;
    }
}