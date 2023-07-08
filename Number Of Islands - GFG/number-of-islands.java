//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        DisjointSet ds = new DisjointSet(rows, cols);
        
        for(int i = 0; i < operators.length; i++){

            int idx = operators[i][0] * cols + operators[i][1];
            if(ds.id[idx] == -1){
                ans++;
                ds.id[idx] = idx;
                
                HashSet<Integer> set = new HashSet<>();
                
                int idU = -1, idD = -1, idL = -1, idR = -1;
                if(operators[i][0] - 1 >= 0){
                    idU = ds.find((operators[i][0] - 1) * cols + operators[i][1]);
                    if(idU != -1){
                        set.add(idU);
                        ds.union(idU, idx);
                    }
                }
                
                if(operators[i][0] + 1 < rows){
                    idD = ds.find((operators[i][0] + 1) * cols + operators[i][1]);
                    if(idD != -1){
                        set.add(idD);
                        ds.union(idD, idx);
                    }
                }
                
                if(operators[i][1] - 1 >= 0){
                    idL = ds.find(operators[i][0] * cols + operators[i][1] - 1);
                    if(idL != -1){
                        set.add(idL);
                        ds.union(idL, idx);
                    }
                }
                
                if(operators[i][1] + 1 < cols){
                    idR = ds.find(operators[i][0] * cols + operators[i][1] + 1);
                    if(idR != -1){
                        set.add(idR);
                        ds.union(idR, idx);
                    }
                }
                
                ans -= set.size();
            }
            
            list.add(ans);
        }
        
        return list;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n, int m){
        this.id = new int[n*m];
        this.size = new int[n*m];
        
        for(int i = 0; i < n*m; i++){
            id[i] = -1;
            size[i] = 0;
        }
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
        } else{
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}

class Pair{
    int x, y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends