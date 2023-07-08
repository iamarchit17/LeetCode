class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        UnionBySize ubs = new UnionBySize(accounts.size());
        
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    ubs.union(i, map.get(accounts.get(i).get(j)));
                } else {
                    map.put(accounts.get(i).get(j), i);
                }    
            }
        }
        
        List<List<String>> merged = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++) merged.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int id = ubs.find(entry.getValue());
            merged.get(id).add(entry.getKey());
        }
        
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            Collections.sort(merged.get(i));
            if(merged.get(i).size() != 0){
                List<String> l = new ArrayList<>();
                l.add(accounts.get(i).get(0));
                for(int j = 0; j < merged.get(i).size(); j++){
                    l.add(merged.get(i).get(j));
                }
                res.add(l);
            }
        }
        
        return res;
    }
}

class UnionBySize{
    int[] id, size;
    
    public UnionBySize(int n){
        this.id = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            id[i] = i;
        }
    }
    
    public int find(int u){
        if(id[u] == u) return u;
        return id[u] = find(id[u]);
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