//{ Driver Code Starts
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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                boolean res = bfs(i, adj, visited);
                if(res) return res;
            }
        }
        
        return false;
    }
    
    public boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        visited[node] = true;
        
        while(q.size() != 0){
            Pair p = q.poll();
            int curr = p.node;
            int parent = p.parent;
            
            for(int x : adj.get(curr)){
                if(x != parent && (!visited[x])){
                    visited[x] = true;
                    q.add(new Pair(x, curr));
                } else if(x != parent && visited[x]) return true;
            }
        }
        
        return false;
    }
}

class Pair{
    int node, parent;
    
    public Pair(int x, int y){
        this.node = x;
        this.parent = y;
    }
}