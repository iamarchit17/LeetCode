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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    set.add(dfs(i, j, grid, visited));
                }
            }
        }
        
        return set.size();
    }
    
    String dfs(int x, int y, int[][] grid, boolean[][] visited){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) return "";
        
        visited[x][y] = true;
        
        String a = "(" + dfs(x-1, y, grid, visited) + ")";
        String b = "(" + dfs(x+1, y, grid, visited) + ")";
        String c = "(" + dfs(x, y-1, grid, visited) + ")";
        String d = "(" + dfs(x, y+1, grid, visited) + ")";

        return "1" + a + b + c + d;
    }
}
