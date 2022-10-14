class Solution {
    List<List<Integer>> adjList = new ArrayList<>();

    public int minimumSemesters(int n, int[][] relations) {
        int[] incomingEdges = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : relations) {
            incomingEdges[arr[1]]++;
            adjList.get(arr[0]).add(arr[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                n--; // we are reducing n 
                for (int neighbour : adjList.get(poll)) {
                    incomingEdges[neighbour]--;
                    if (incomingEdges[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
            count++;
        }
        return n == 0 ? count : -1;
    }
}
