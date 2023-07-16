class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if(nums.length == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        int max = nums[0];
        for(int i : nums){
            if(i == 1) return false;
            if(i > max) max = i;
            set.add(i);
        }
        
        DisjointSet ds = new DisjointSet(set);

        int[] sieve = new int[max+1];
        
        for(int i = 2; i <= max; i++){
            boolean flag = false;
            int baseIdx = i;
            for(int j = i; j <= max; j += i){
                if(set.contains(j)){
                    if(!flag){
                        baseIdx = ds.find(j);
                        flag = true;
                    } else {
                        ds.union(baseIdx, j);
                    } 
                }
            }
        }
        
        for(int i : set){
            for(int j : set){
                if(i != j && ds.find(i) != ds.find(j)) return false;
            }
        }
        
        return true;
    }
}

class DisjointSet{
    HashMap<Integer, Integer> id, size;
    
    public DisjointSet(HashSet<Integer> set){
        this.id = new HashMap<>();
        this.size = new HashMap<>();
        for(int i : set){
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
            size.put(idV, size.get(idV) + size.get(idU));
        } else {
            id.put(idV, idU);
            size.put(idU, size.get(idU) + size.get(idV));
        }
    }
}