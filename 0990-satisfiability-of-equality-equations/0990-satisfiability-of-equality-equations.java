class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet(26);
        
        for(int i = 0; i < equations.length; i++){
            if(equations[i].charAt(1) == '=') {
                int c1 = equations[i].charAt(0) - 97;
                int c2 = equations[i].charAt(3) - 97;    
                ds.union(c1, c2);
            }
        }
        
        for(int i = 0; i < equations.length; i++){
            if(equations[i].charAt(1) == '!') {
                int c1 = equations[i].charAt(0) - 97;
                int c2 = equations[i].charAt(3) - 97;    
                if(ds.find(c1) == ds.find(c2)) return false;
            }
        }
        
        return true;
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
        if(size[idU] <= size[idV]){
            id[idU] = idV;
            size[idV] += size[idU];
        } else {
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}