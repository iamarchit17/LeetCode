class Solution {
    public int largestComponentSize(int[] nums) {
        int max = nums[0];
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(i > max) max = i;
            set.add(i);
        }
        
        DisjointSet ds = new DisjointSet(nums);
        int[] sieve = new int[max+1];
        for(int i = 2; i <= max; i++){
            int baseIdx = i;
            boolean flag = false;
            for(int j = i; j <= max; j+=i){
                if(set.contains(j)){
                    if(!flag){
                        flag = true;
                        baseIdx = j;
                    } else {
                        ds.union(j, baseIdx);
                    }
                } 
            }
        }
        
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : ds.size.entrySet()){
            if(entry.getValue() > res) res = entry.getValue();
        }
        
        return res;
    }
}

class DisjointSet{
    HashMap<Integer, Integer> id, size;
    
    public DisjointSet(int[] nums){
        this.id = new HashMap<>();
        this.size = new HashMap<>();
        
        for(int i : nums){
            id.put(i, i);
            size.put(i, 1);
        }
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