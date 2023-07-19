//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < V; i++){
            if(!visited[i]) dfs(i, visited, adj, dq);
        }
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < V; i++) revAdj.add(new ArrayList<>());
        
        for(int i = 0; i < V; i++){
            for(int j : adj.get(i)) revAdj.get(j).add(i);
        }
        
        int count = 0;
        Arrays.fill(visited, false);
        
        while(dq.size() != 0){
            if(!visited[dq.peek()]){
                dfs(dq.peek(), visited, revAdj);
                count++;
            }
            dq.pop();
        }
        
        return count;
    }
    
    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Deque<Integer> dq){
        visited[node] = true;
        
        for(int nbr: adj.get(node)){
            if(!visited[nbr]) dfs(nbr, visited, adj, dq);
        }
        
        dq.push(node);
    }
    
    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        
        for(int nbr: adj.get(node)){
            if(!visited[nbr]) dfs(nbr, visited, adj);
        }
    }
}
