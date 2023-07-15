class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet ds = new DisjointSet(s.length());
        for(int i = 0; i < pairs.size(); i++) ds.union(pairs.get(i).get(0), pairs.get(i).get(1));
        
        HashMap<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int id = ds.find(i);
            if(!map.containsKey(id)) map.put(id, new ArrayList<>());
            map.get(id).add(s.charAt(i));
        }
        
        HashMap<Integer, Integer> indices = new HashMap<>();
        for(Map.Entry<Integer, List<Character>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
            indices.put(entry.getKey(), 0);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int id = ds.find(i);
            sb.append(map.get(id).get(indices.get(id)));
            indices.put(id, indices.get(id) + 1);
        }
        
        return sb.toString();
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