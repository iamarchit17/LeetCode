//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][]){
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n-1){
                    if(a[i][j] == 'O' && (!visited[i][j])) dfs(i, j, a, visited);
                } else {
                    if(j == 0 || j == m - 1){
                        if(a[i][j] == 'O' && (!visited[i][j])) dfs(i, j, a, visited);
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && a[i][j] == 'O') a[i][j] = 'X';
            }
        }
        
        return a;
    }
    
    static void dfs(int x, int y, char a[][], boolean[][] visited){
        visited[x][y] = true;
        
        if(x - 1 >= 0 && a[x-1][y] == 'O' && (!visited[x-1][y])) dfs(x-1, y, a, visited);
        if(x + 1 < a.length && a[x+1][y] == 'O' && (!visited[x+1][y])) dfs(x+1, y, a, visited);
        if(y-1 >= 0 && a[x][y-1] == 'O' && (!visited[x][y-1])) dfs(x, y-1, a, visited);
        if(y+1 < a[0].length && a[x][y+1] == 'O' && (!visited[x][y+1])) dfs(x, y+1, a, visited);
    }
}