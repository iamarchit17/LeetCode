class Solution {
    
    private boolean areSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        
        if(count > 2) return false;
        
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
        DisjointSet ds = new DisjointSet(strs.length);
        
        for(int i = 0; i < strs.length; i++){
            for(int j = i+1; j < strs.length; j++){
                if(areSimilar(strs[i], strs[j])) ds.union(i, j);
            }
        }
        
        int groups = 0;
        for(int i = 0; i < strs.length; i++){
            if(ds.find(i) == i) groups++;
        }
        
        return groups;
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