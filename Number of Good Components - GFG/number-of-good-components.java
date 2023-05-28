//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V+1];
        int gc = 0;
        for(int i = 1; i <=  V; i++){
            if(!visited[i]){
                int[] count = new int[2];
                dfs(i, adj, count, visited);
                if((count[0] * (count[0] - 1)) == count[1]) gc++;
            }
        }
        
        return gc;
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] count, boolean[] visited){
        visited[node] = true;
        count[0]++;
        count[1] += adj.get(node).size();
        
        for(int x : adj.get(node)){
            if(!visited[x]) dfs(x, adj, count, visited);
        }
    }
}