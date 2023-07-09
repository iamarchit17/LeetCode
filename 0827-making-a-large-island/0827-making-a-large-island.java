class Solution {
    private boolean isValid(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    if(isValid(i-1, j, n) && grid[i-1][j] == 1) ds.union(i*n+j, (i-1)*n+j);
                    if(isValid(i+1, j, n) && grid[i+1][j] == 1) ds.union(i*n+j, (i+1)*n+j);
                    if(isValid(i, j-1, n) && grid[i][j-1] == 1) ds.union(i*n+j, i*n+j-1);
                    if(isValid(i, j+1, n) && grid[i][j+1] == 1) ds.union(i*n+j, i*n+j+1);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    if(isValid(i-1, j, n) && grid[i-1][j] == 1) set.add(ds.find((i-1)*n+j));
                    if(isValid(i+1, j, n) && grid[i+1][j] == 1) set.add(ds.find((i+1)*n+j));
                    if(isValid(i, j-1, n) && grid[i][j-1] == 1) set.add(ds.find(i*n+j-1));
                    if(isValid(i, j+1, n) && grid[i][j+1] == 1) set.add(ds.find(i*n+j+1));
                    
                    int s = 1;
                    for(int k : set) s += ds.size[k];
                    if(s > max) max = s;
                }
            }
        }
        
        max = Math.max(max, ds.size[ds.find(0)]);
        
        return max;
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