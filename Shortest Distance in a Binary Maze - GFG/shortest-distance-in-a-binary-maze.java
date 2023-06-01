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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
//BFS Solution
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(grid[source[0]][source[1]] == 0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(source[0], source[1]));
        visited[source[0]][source[1]] = true;
        
        int dist = 0;
        while(dq.size() != 0){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                Pair p =dq.poll();
                int x = p.x;
                int y = p.y;
                if(destination[0] == x && destination[1] == y) return dist;
                
                if(x-1 >= 0 && grid[x-1][y] == 1 && !visited[x-1][y]){
                    visited[x-1][y] = true;
                    dq.add(new Pair(x-1, y));
                }
                
                if(x+1 < n && grid[x+1][y] == 1 && !visited[x+1][y]){
                    visited[x+1][y] = true;
                    dq.add(new Pair(x+1, y));
                }
                
                if(y-1 >= 0 && grid[x][y-1] == 1 && !visited[x][y-1]){
                    visited[x][y-1] = true;
                    dq.add(new Pair(x, y-1));
                }
                
                if(y+1 < m && grid[x][y+1] == 1 && !visited[x][y+1]){
                    visited[x][y+1] = true;
                    dq.add(new Pair(x, y+1));
                }
            }
            dist++;
        }
        
        return -1;
    }
    
}

class Pair{
    int x, y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}