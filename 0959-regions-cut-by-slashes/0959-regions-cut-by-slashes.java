class Solution {
    
    private boolean isValid(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n * 4);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                int idx = 4 * (i * n + j);
                if(isValid(i, j+1, n)){
                    ds.union(idx + 2, (4 * (i * n + j + 1)) + 1);
                }
                
                if(isValid(i+1, j, n)){
                    ds.union(idx + 3, (4 * ((i+1) * n + j)));
                }
                
                if(grid[i].charAt(j) == ' '){
                    ds.union(idx, idx+1);
                    ds.union(idx, idx+2);
                    ds.union(idx, idx+3);
                } else if(grid[i].charAt(j) == '/'){
                    ds.union(idx, idx+1);
                    ds.union(idx+2, idx+3);
                } else{
                    ds.union(idx, idx+2);
                    ds.union(idx+1, idx+3);
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i < 4 * n * n; i++){
            if(ds.id[i] == i) ans++;
        }
        
        return ans;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n];
        this.size = new int[n];
        
        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++) id[i] = i;
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