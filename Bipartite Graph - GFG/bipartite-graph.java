//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends

//BFS Solution
// class Solution{
//     public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
//         int[] visited = new int[V];
//         Arrays.fill(visited, -1);
//         for(int i = 0; i < V; i++){
//             if(visited[i] == -1){
//                 boolean x = bfs(i, visited, adj);
//                 if(!x) return false;
//             }
//         }
        
//         return true;
//     }
    
//     public boolean bfs(int node, int[] visited, ArrayList<ArrayList<Integer>>adj){
//         visited[node] = 0;
//         Queue<Integer> q = new LinkedList<>();
//         q.add(node);
//         int nColor = 1;
        
//         while(q.size() != 0){
//             int size = q.size();

//             for(int i = 0; i < size; i++){
//                 int curr = q.poll();
                
//                 for(int x : adj.get(curr)){
//                     if(visited[x] == -1){
//                         visited[x] = nColor;
//                         q.add(x);
//                     } else if(visited[x] != nColor) return false;
//                 }
//             }
            
//             nColor = 1 - nColor;
//         }
        
//         return true;
//     }
// }


//DFS Solution
class Solution{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        for(int i = 0; i < V; i++){
            if(visited[i] == -1){
                if(!dfs(i, 0, visited, adj)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, int currColor, int[] visited, ArrayList<ArrayList<Integer>>adj){
        visited[node] = currColor;
        int nColor = 1 - currColor;
        for(int x : adj.get(node)){
            if(visited[x] == currColor) return false;
            else if(visited[x] == -1){
                if(!dfs(x, nColor, visited, adj)) return false;
            }
        }

        return true;
    }
}