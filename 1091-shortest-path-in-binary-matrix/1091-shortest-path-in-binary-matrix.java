class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        queue.add(new int[]{0, 0, 1});
        visited.add(0 + "-" + 0);
        int count = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int distance = arr[2];
            if(x == grid.length-1 && y == grid[0].length-1){
                return distance;
            }
            count++;
            for (int[] dir : directions) {
                int X = dir[0] + arr[0];
                int Y = dir[1] + arr[1];
                if (X < 0 || Y < 0 || X > grid.length - 1 || Y > grid[0].length - 1) {
                    continue;
                }
                if (grid[X][Y] == 1) {
                    continue;
                }
                if (visited.contains(X + "-" + Y)) {
                    continue;
                }
                visited.add(X + "-" + Y);
                queue.add(new int[]{X, Y,distance+1});
            }
        }
        return -1;
    }
}