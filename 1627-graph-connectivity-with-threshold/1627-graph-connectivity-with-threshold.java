class Solution {
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        if(threshold == 0){
            for(int i = 0; i < queries.length; i++) res.add(true);
            return res;
        }
        
        DisjointSet ds = new DisjointSet(n);
        for(int i = threshold + 1; i <= n; i++){
            for(int j = i + i; j <= n; j += i) ds.union(i, j);
        }
        
        for(int i = 0; i < queries.length; i++){
            res.add(ds.find(queries[i][0]) == ds.find(queries[i][1]));
        }
        
        return res;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n+1];
        this.size = new int[n+1];
        
        for(int i = 0; i <= n; i++) id[i] = i;
        Arrays.fill(size, 1);
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