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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int Solve(int n, int[][] edge) {
        UnionBySize ubs = new UnionBySize(n);
        
        for(int i = 0; i < edge.length; i++){
            ubs.union(edge[i][0], edge[i][1]);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) if(ubs.id[i] == i) count++;
        
        int m = edge.length;
        
        if(m < n - 1) return -1;
        
        return count - 1;
    }
}

class UnionBySize{
    int[] id, size;
    
    public UnionBySize(int n){
        this.id = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int u){
        if(id[u] == u) return u;
        return id[u] = find(id[u]);
    }
    
    public void union(int u, int v){
        int idU = find(u);
        int idV = find(v);
        
        if(idU == idV) return;
        if(size[idU] < size[idV]){
            id[idU] = idV;
            size[idV] += size[idU];
        } else{
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}