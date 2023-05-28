//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int provinces = 0;
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, visited, adj);
            }
        }
        
        return provinces;
    }
    
    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        
        for(int i = 0; i < adj.size(); i++){
            if(adj.get(node).get(i) == 1 && !visited[i]) dfs(i, visited, adj);
        }
    }
};