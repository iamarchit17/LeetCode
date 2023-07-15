class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        DisjointSet ds = new DisjointSet(source.length);
        
        for(int i = 0; i < allowedSwaps.length; i++) ds.union(allowedSwaps[i][0], allowedSwaps[i][1]);
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        
        for(int i = 0; i < source.length; i++){
            int id = ds.find(i);
            if(!map.containsKey(id)) map.put(id, new HashMap<>());
            map.get(id).put(source[i], map.get(id).getOrDefault(source[i], 0) + 1);
        }
        
        int eqs = 0;
        for(int i = 0; i < target.length; i++){
            int id = ds.find(i);
            if(map.get(id).containsKey(target[i]) && map.get(id).get(target[i]) > 0){
                eqs++;
                map.get(id).put(target[i], map.get(id).get(target[i]) - 1);
            }
        }
        
        return source.length - eqs;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n+1];
        this.size = new int[n+1];
        for(int i = 0; i < n+1; i++){
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