//{ Driver Code Starts
// Initial Template for Java

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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n-1){
                    if(grid[i][j] == 1) dfs(i, j, grid);
                } else {
                    if(j == 0 || j == m - 1){
                        if(grid[i][j] == 1) dfs(i, j, grid);
                    }
                }
            }
        }
        
        int enclaves = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                enclaves += grid[i][j];
            }
        }
        
        return enclaves;
    }
    
    void dfs(int x, int y, int[][] grid){
        grid[x][y] = 0;
        
        if(x - 1 >= 0 && grid[x-1][y] == 1) dfs(x-1, y, grid);
        if(x + 1 < grid.length && grid[x+1][y] == 1) dfs(x+1, y, grid);
        if(y-1 >= 0 && grid[x][y-1] == 1) dfs(x, y-1, grid);
        if(y+1 < grid[0].length && grid[x][y+1] == 1) dfs(x, y+1, grid);
    }
}