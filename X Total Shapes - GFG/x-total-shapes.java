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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'X' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int x, int y, boolean[][] visited, char[][] grid){
        visited[x][y] = true;
        
        if(x-1 >= 0 && grid[x-1][y] == 'X' && !visited[x-1][y]) dfs(x-1, y, visited, grid);
        if(x+1 < grid.length && grid[x+1][y] == 'X' && !visited[x+1][y]) dfs(x+1, y, visited, grid);
        if(y-1 >= 0 && grid[x][y-1] == 'X' && !visited[x][y-1]) dfs(x, y-1, visited, grid);
        if(y+1 < grid[0].length && grid[x][y+1] == 'X' && !visited[x][y+1]) dfs(x, y+1, visited, grid);
    }
}