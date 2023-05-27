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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid){
        
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2) q.add(new Pair(i, j));
            }
        }
        
        int time = 0;
        while(q.size() != 0){
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                
                if(x - 1 >= 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    q.add(new Pair(x-1, y));
                }
                
                if(x + 1 < n && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    q.add(new Pair(x+1, y));
                }
                
                if(y - 1 >= 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    q.add(new Pair(x, y-1));
                }
                
                if(y + 1 < m && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    q.add(new Pair(x, y+1));
                }
            }
            
            if(q.size() != 0) time++;
        }
        
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) fresh++;
            }
        }
        
        return fresh > 0 ? -1 : time;
    }
}

class Pair{
    int x, y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}