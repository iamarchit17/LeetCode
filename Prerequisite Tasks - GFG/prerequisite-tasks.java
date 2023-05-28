//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] preqs){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < preqs.length; i++) adj.get(preqs[i][1]).add(preqs[i][0]);
        
        boolean[] visited = new boolean[N];
        boolean[] path = new boolean[N];
        
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, path)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]){
                if(dfs(x, adj, visited, path)) return true;
            } else if(path[x]) return true;
        }
        
        path[node] = false;
        return false;
    }
    
}