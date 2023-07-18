class Solution {
    public boolean gcdSort(int[] nums) {
        DisjointSet ds = new DisjointSet(nums.length);
        HashMap<Integer, List<Integer>> indices = new HashMap<>();
         
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
            if(indices.containsKey(nums[i])) indices.get(nums[i]).add(i);
            else{
                indices.put(nums[i], new ArrayList<>());
                indices.get(nums[i]).add(i);
            }
        }
        
        for(int i = 2; i <= max; i++){
            List<Integer> baseIdx = new ArrayList<>();
            boolean flag = false;
            for(int j = i; j <= max; j+=i){
                if(indices.containsKey(j)){
                    if(!flag){
                        flag = true;
                        baseIdx = new ArrayList<>(indices.get(j));
                    } else {
                        for(int u : baseIdx){
                            for(int v : indices.get(j)) ds.union(u, v);
                        }
                    }
                }
            }
        }
        
        
        HashMap<Integer, List<Integer>> connected = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int id = ds.find(i);
            if(!connected.containsKey(id)) connected.put(id, new ArrayList<>());
            connected.get(id).add(nums[i]);
        }
        
        
        
        HashMap<Integer, Integer> idx = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> entry : connected.entrySet()){
            Collections.sort(entry.getValue());
            idx.put(entry.getKey(), 0);
        }
        
        
        int b = connected.get(ds.find(0)).get(idx.get(ds.find(0)));
        idx.put(ds.find(0), idx.get(ds.find(0)) + 1);
        
        for(int i = 1; i < nums.length; i++){
            int id = ds.find(i);
            int ele = connected.get(id).get(idx.get(id));
            if(ele < b) return false;
            b = ele;
            idx.put(id, idx.get(id) + 1);
        }
        
        return true;
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