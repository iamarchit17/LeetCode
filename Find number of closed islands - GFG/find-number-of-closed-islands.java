//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int closedIslands(int[][] matrix, int N, int M){
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i == 0 || j == 0 || i == N - 1 || j == M - 1){
                    if(matrix[i][j] == 1 && !visited[i][j]) dfs(i, j, visited, matrix);
                }
            }
        }
        
        int closedIslands = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!(i == 0 || j == 0 || i == N - 1 || j == M - 1)){
                    if(matrix[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, visited, matrix);
                        closedIslands++;
                    }
                }
            }
        }
        
        return closedIslands;
    }
    
    public void dfs(int x, int y, boolean[][] visited, int[][] grid){
        visited[x][y] = true;
        
        if(x-1 >= 0 && grid[x-1][y] == 1 && !visited[x-1][y]) dfs(x-1, y, visited, grid);
        if(x+1 < grid.length && grid[x+1][y] == 1 && !visited[x+1][y]) dfs(x+1, y, visited, grid);
        if(y-1 >= 0 && grid[x][y-1] == 1 && !visited[x][y-1]) dfs(x, y-1, visited, grid);
        if(y+1 < grid[0].length && grid[x][y+1] == 1 && !visited[x][y+1]) dfs(x, y+1, visited, grid);
    }
}