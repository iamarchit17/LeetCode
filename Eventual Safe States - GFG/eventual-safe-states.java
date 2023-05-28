//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]) dfs(i, visited, path, adj);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!path[i]) list.add(i);
        }
        
        return list;
    }
    
    boolean dfs(int node, boolean[] visited, boolean[] path, List<List<Integer>> adj){
        visited[node] = true;
        path[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]){
                if(dfs(x, visited, path, adj)) return true;
            } else if(path[x]) return true;
        }
        
        path[node] = false;
        return false;
    }
}
