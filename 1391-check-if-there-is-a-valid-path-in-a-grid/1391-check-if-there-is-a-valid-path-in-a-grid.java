class Solution {
    private boolean isValid(int i, int j, int m, int n){
        return i >= 0 && j >= 0 && i < m && j < n;
    }
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        HashSet<Integer> up = new HashSet<>();
        HashSet<Integer> down = new HashSet<>();
        
        left.add(1); left.add(4); left.add(6);
        right.add(1); right.add(3); right.add(5);
        up.add(2); up.add(3); up.add(4);
        down.add(2); down.add(5); down.add(6);
           
        DisjointSet ds = new DisjointSet(m * n);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // System.out.println(grid[i][j]);
                // System.out.println(i * m + j);
                // System.out.println(i * m + j - 1 + " left " + (i * m + j + 1) + " right");
                // System.out.println((i - 1) * m + j + " up " + ((i+1) * m + j) + " down");
                if(grid[i][j] == 1){
                    if(isValid(i, j-1, m, n) && left.contains(grid[i][j-1])) ds.union((i * n) + j, (i * n) + j - 1);
                    if(isValid(i, j+1, m, n) && right.contains(grid[i][j+1])) ds.union((i * n) + j, (i * n) + j + 1);
                } else if(grid[i][j] == 2){
                    if(isValid(i-1, j, m, n) && up.contains(grid[i-1][j])) ds.union((i * n) + j, (i - 1) * n + j);
                    if(isValid(i+1, j, m, n) && down.contains(grid[i+1][j])) ds.union((i * n) + j, (i + 1) * n + j);
                } else if(grid[i][j] == 3){
                    if(isValid(i, j-1, m, n) && left.contains(grid[i][j-1])) ds.union((i * n) + j, (i * n) + j - 1);
                    if(isValid(i+1, j, m, n) && down.contains(grid[i+1][j])) ds.union((i * n) + j, (i + 1) * n + j);
                } else if(grid[i][j] == 4){
                    if(isValid(i, j+1, m, n) && right.contains(grid[i][j+1])) ds.union((i * n) + j, (i * n) + j + 1);
                    if(isValid(i+1, j, m, n) && down.contains(grid[i+1][j])) ds.union((i * n) + j, (i + 1) * n + j);
                } else if(grid[i][j] == 5){
                    if(isValid(i-1, j, m, n) && up.contains(grid[i-1][j])) ds.union((i * n) + j, (i - 1) * n + j);
                    if(isValid(i, j-1, m, n) && left.contains(grid[i][j-1])) ds.union((i * n) + j, (i * n) + j - 1);
                } else {
                    if(isValid(i-1, j, m, n) && up.contains(grid[i-1][j])) ds.union((i * n) + j, (i - 1) * n + j);
                    if(isValid(i, j+1, m, n) && right.contains(grid[i][j+1])) ds.union((i * n) + j, (i * n) + j + 1);  
                }
            }
        }
        
        return ds.find(0) == ds.find(m * n - 1);
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n];
        this.size = new int[n];
        for(int i = 0; i < n; i++){
            size[i] = 1;
            id[i] = i;
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
        } else{
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}