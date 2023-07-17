class Solution {
    public int longestConsecutive(int[] nums) {
        DisjointSet ds = new DisjointSet();
        
        for(int i = 0; i < nums.length; i++){
            if(!ds.id.containsKey(nums[i])){
                ds.id.put(nums[i], nums[i]);
                ds.size.put(nums[i], 1);
                
                if(ds.id.containsKey(nums[i] + 1)) ds.union(nums[i], nums[i] + 1);
                if(ds.id.containsKey(nums[i] - 1)) ds.union(nums[i], nums[i] - 1);
            }
        }
        
        int max = 0;
        
        for(Map.Entry<Integer, Integer> entry : ds.id.entrySet()){
            if(ds.find(entry.getKey()) == entry.getKey() && ds.size.get(entry.getKey()) > max){
                max = ds.size.get(entry.getKey());
            }
        }
        
        return max;
    }
}

class DisjointSet{
    HashMap<Integer, Integer> id, size;
    
    public DisjointSet(){
        this.id = new HashMap<>();
        this.size = new HashMap<>();
    }
    
    public int find(int n){
        if(id.get(n) == n) return n;
        id.put(n, find(id.get(n)));
        return id.get(n);
    }
    
    public void union(int u, int v){
        int idU = find(u);
        int idV = find(v);
        if(idU == idV) return;
        if(size.get(idU) < size.get(idV)){
            id.put(idU, idV);
            size.put(idV, size.get(idU) + size.get(idV));
        } else {
            id.put(idV, idU);
            size.put(idU, size.get(idU) + size.get(idV));
        }
    }
}