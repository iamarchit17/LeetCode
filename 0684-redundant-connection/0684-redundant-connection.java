class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        
        for(int i = 0; i < n; i++){
            if(ds.find(edges[i][0]) == ds.find(edges[i][1])) return edges[i];
            else ds.union(edges[i][0], edges[i][1]);
        }
        
        return new int[]{0,0};
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n+1];
        this.size = new int[n+1];
        
        for(int i = 0; i < n; i++) id[i] = i;
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