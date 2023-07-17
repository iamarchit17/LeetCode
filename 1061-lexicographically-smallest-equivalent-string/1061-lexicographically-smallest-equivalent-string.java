class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet ds = new DisjointSet(26);
        
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) ds.union(s1.charAt(i) - 97, s2.charAt(i) - 97);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            int id = ds.find(i);
            if(map.containsKey(id)){
                if(i < map.get(id)) map.put(id, i);
            } else map.put(id, i);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            sb.append((char) (map.get(ds.find(baseStr.charAt(i) - 97)) + 97));
        }
        
        return sb.toString();
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
        } else{
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}