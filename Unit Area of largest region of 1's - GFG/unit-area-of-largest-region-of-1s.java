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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    public int findMaxArea(int[][] grid){
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int[] area = new int[1];
                    dfs(i, j, grid, visited, area);
                    if(area[0] > max) max = area[0];
                }
            }
        }
        
        return max;
    }
    
    public void dfs(int x, int y, int[][] grid, boolean[][] visited, int[] area){
        visited[x][y] = true;
        area[0]++;
        
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(x - i >= 0 && x - i < grid.length && y - j >= 0 && y - j < grid[0].length && grid[x - i][y - j] == 1 && !visited[x - i][y - j]){
                    dfs(x - i, y - j, grid, visited, area);
                }
            }
        }
    }
}