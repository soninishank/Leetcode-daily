class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] arr : edges)
        {
           adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(!visited.contains(i))
            {
                count++;
                applyDFS(visited,i,adjList);
            }
        }
        return count;
    }
    
    void applyDFS(HashSet<Integer> hashset,int edge,List<List<Integer>> adjList)
    {
        hashset.add(edge);
        for(int child : adjList.get(edge))
        {
            if(!hashset.contains(child))
            {
                applyDFS(hashset,child,adjList);
            }
        }
    }
}