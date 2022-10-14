class Solution {
    
    List<List<Integer>> adjList = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++)
        {
            adjList.add(new ArrayList<>());
        }
        int[] incomingEdges = new int[numCourses];
        for(int[] arr : prerequisites)
        {
            adjList.get(arr[1]).add(arr[0]);
            incomingEdges[arr[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < incomingEdges.length ; i++)
        {
            if(incomingEdges[i]== 0)
            {
              queue.add(i);   
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        int totalEdges = prerequisites.length;
        while(!queue.isEmpty())
        {
            int val = queue.poll();
            result[i] = val;
            i++;
            for(int child : adjList.get(val))
            {
                incomingEdges[child]--;
                totalEdges--;
                if(incomingEdges[child] == 0)
                {
                    queue.add(child);
                }
            }
        }
        return totalEdges == 0 ? result : new int[]{};
    }
}