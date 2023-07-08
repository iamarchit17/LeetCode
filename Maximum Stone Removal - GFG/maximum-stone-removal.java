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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int maxRemove(int[][] stones, int n) {
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        
        for(int i = 0; i < stones.length; i++){
            if(mapX.containsKey(stones[i][0])) ds.union(i, ds.find(mapX.get(stones[i][0])));
            else mapX.put(stones[i][0], i);
            
            if(mapY.containsKey(stones[i][1])) ds.union(i, ds.find(mapY.get(stones[i][1])));
            else mapY.put(stones[i][1], i);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(ds.id[i] == i) ans += (ds.size[i] - 1);
        }
        
        return ans;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int n){
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
