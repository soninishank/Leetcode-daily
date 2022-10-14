class Solution {
    
     List<List<Integer>> adjList = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            incomingEdges[arr[0]]++;
            adjList.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int edgeCnt = prerequisites.length;
        int[] res = new int[numCourses]; // to store the order
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            res[index] = current; // ordering
            index++;
            for (int neighbour : adjList.get(current)) {
                edgeCnt--;
                incomingEdges[neighbour]--;
                if (incomingEdges[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return edgeCnt == 0 ? res : new int[0];
    }

}