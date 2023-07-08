//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n, n);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int idx = i * n + j;
                    if(ds.id[idx] == -1){
                        ds.id[idx] = idx;
                        ds.size[idx] = 1;
                        
                        if(i - 1 >= 0){
                            int idU = ds.find((i-1) * n + j);
                            if(idU != -1) ds.union(idU, idx);
                        }
                        
                        if(i + 1 < n){
                            int idD = ds.find((i+1) * n + j);
                            if(idD != -1) ds.union(idD, idx);
                        }
                        
                        if(j - 1 >= 0){
                            int idL = ds.find(i * n + j - 1);
                            if(idL != -1) ds.union(idL, idx);
                        }
                        
                        if(j + 1 < n){
                            int idR = ds.find(i * n + j + 1);
                            if(idR != -1) ds.union(idR, idx);
                        }
                    }
                }
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(ds.size[i*n+j] > max) max = ds.size[i*n+j];
                if(grid[i][j] == 0){
                    int s = 1;
                    HashSet<Integer> set = new HashSet<>();
                    
                    if(i - 1 >= 0){
                        int idU = ds.find((i-1) * n + j);
                        if(idU != -1 && !set.contains(idU)){
                            s += ds.size[idU];
                            set.add(idU);
                        }
                    }
                    
                    if(i + 1 < n){
                        int idD = ds.find((i+1) * n + j);
                        if(idD != -1 && !set.contains(idD)){
                            s += ds.size[idD];
                            set.add(idD);
                        }
                    }
                    
                    if(j - 1 >= 0){
                        int idL = ds.find(i * n + j - 1);
                        if(idL != -1 && !set.contains(idL)){
                            s += ds.size[idL];
                            set.add(idL);
                        }
                    }
                    
                    if(j + 1 < n){
                        int idR = ds.find(i * n + j + 1);
                        if(idR != -1 && !set.contains(idR)){
                            s += ds.size[idR];
                            set.add(idR);
                        }
                    }
                    
                    if(s > max) max = s;
                }
            }
        }
        
        return max;
    }
    
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n, int m){
        this.id = new int[n*m];
        this.size = new int[n*m];
        
        Arrays.fill(id, -1);
        Arrays.fill(size, 0);
    }
    
    public int find(int n){
        if(id[n] == -1) return -1;
        if(id[n] == n) return n;
        return id[n] = find(id[n]);
    }
    
    public void union(int u, int v){
        int idU = find(u);
        int idV = find(v);
        
        if(idU == idV) return;
        if(size[idU] < size[idV]){
            id[idU] = idV;
            size[idV] += size[idU];
        } else {
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}