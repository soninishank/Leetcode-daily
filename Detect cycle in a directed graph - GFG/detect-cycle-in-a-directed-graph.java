//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];
        
        for(int i = 0 ; i < V ; i++)
        {
            // if not visited
            if(visited[i] == false)
            {
                if(isCycle(adj,visited,dfsVisited,i))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean dfsVisited[],int current)
    {
        visited[current] = true;
        dfsVisited[current] = true;
        for(int child : adj.get(current))
        {
            if(visited[child] == false)
            {
                if(isCycle(adj,visited,dfsVisited,child))
                {
                   return true; 
                }
            }else if(dfsVisited[child])
            {
                return true;
            }
        }
        dfsVisited[current] = false;
        return false;
    }
}