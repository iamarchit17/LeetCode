class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        DisjointSet ds = new DisjointSet(n*m);
        boolean[][] visited = new boolean[n][m];
       
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                if(isValid(i-1, j, n, m) && grid[i-1][j] == grid[i][j] && !visited[i-1][j]){
                    if(ds.find(i * m + j) == ds.find((i - 1) * m + j)) return true;
                    else ds.union(i * m + j, (i - 1) * m + j);
            
                }
                
                if(isValid(i+1, j, n, m) && grid[i+1][j] == grid[i][j] && !visited[i+1][j]) {
                    if(ds.find(i * m + j) == ds.find((i+1) * m + j)) return true;
                    else ds.union(i * m + j, (i + 1) * m + j);
                }
                
                if(isValid(i, j-1, n, m) && grid[i][j-1] == grid[i][j] && !visited[i][j-1]){
                    if(ds.find(i * m + j) == ds.find(i * m + j - 1)) return true;
                    else ds.union(i * m + j, i * m + j - 1);
                }
                
                if(isValid(i, j+1, n, m) && grid[i][j+1] == grid[i][j] && !visited[i][j+1]){
                    if(ds.find(i * m + j + 1) == ds.find(i * m + j)) return true;
                    else ds.union(i * m + j, i * m + j + 1);
                } 
            }
        }
        
        return false;
    }
    
    private boolean isValid(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n];
        this.size = new int[n];
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