//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges,int distanceThreshold){
        int[][] adj = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i] = 0;
        } 
        
        for(int i = 0; i < m; i++){
            adj[edges[i][0]][edges[i][1]] = edges[i][2];
            adj[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int thru = 0; thru < n; thru++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(adj[i][thru] != Integer.MAX_VALUE && adj[thru][j] != Integer.MAX_VALUE){
                        if(adj[i][thru] + adj[thru][j] < adj[i][j]) adj[i][j] = adj[i][thru] + adj[thru][j];
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int cities = 0;
            for(int j = 0; j < n; j++){
                if(adj[i][j] <= distanceThreshold) cities++;
            }
            
            if(cities <= min){
                min = cities;
                ans = i;
            }
        }
        
        return ans;
    }
}
