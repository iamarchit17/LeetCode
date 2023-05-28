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

//DFS Solution
// class Solution {
//     // Function to detect cycle in a directed graph.
//     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean[] visited = new boolean[V];
//         boolean[] path = new boolean[V];
//         for(int i = 0; i < V; i++){
//             if(!visited[i]){
//                 if(dfs(i, adj, visited, path)) return true;
//             }
//         }
        
//         return false;
//     }
    
//     public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path){
//         visited[node] = true;
//         path[node] = true;
        
//         for(int x : adj.get(node)){
//             if(path[x]) return true;
//             else if(!visited[x]){
//                 if(dfs(x, adj, visited, path)) return true;
//             }
//         }
        
//         path[node] = false;
//         return false;
//     }
// }


//BFS Solution - Topological Sorting
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int x : adj.get(i)){
                inDegree[x]++;
            }
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> topoSort = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0) {
                dq.add(i);
            }
        }
        
        while(dq.size() != 0){
            int x = dq.pop();
            topoSort.add(x);
            for(int i : adj.get(x)){
                inDegree[i]--;
                if(inDegree[i] == 0) dq.add(i);
                
            }
        }
        
        return topoSort.size() < V;
    }
}





