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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] res = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    res[i][j] = 0;
                }
            }
        }
        
        int dist = 0;
        while(q.size() != 0){
            dist++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                
                if(x - 1 >= 0 && grid[x-1][y] == 0){
                    q.add(new Pair(x-1, y));
                    grid[x-1][y] = 1;
                    res[x-1][y] = dist;
                }
                
                if(x + 1 < n && grid[x+1][y] == 0){
                    q.add(new Pair(x+1, y));
                    grid[x+1][y] = 1;
                    res[x+1][y] = dist;
                }
                
                if(y - 1 >= 0 && grid[x][y-1] == 0){
                    q.add(new Pair(x, y-1));
                    grid[x][y-1] = 1;
                    res[x][y-1] = dist;
                }
                
                if(y + 1 < m && grid[x][y+1] == 0){
                    q.add(new Pair(x, y+1));
                    grid[x][y+1] = 1;
                    res[x][y+1] = dist;
                }
            }
        }
        
        return res;
    }
}

class Pair{
    int x, y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}