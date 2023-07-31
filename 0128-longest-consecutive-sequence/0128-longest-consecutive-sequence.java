// class Solution {
//     public int longestConsecutive(int[] nums) {
//         DisjointSet ds = new DisjointSet();
        
//         for(int i = 0; i < nums.length; i++){
//             if(!ds.id.containsKey(nums[i])){
//                 ds.id.put(nums[i], nums[i]);
//                 ds.size.put(nums[i], 1);
                
//                 if(ds.id.containsKey(nums[i] + 1)) ds.union(nums[i], nums[i] + 1);
//                 if(ds.id.containsKey(nums[i] - 1)) ds.union(nums[i], nums[i] - 1);
//             }
//         }
        
//         int longest = 0;
        
//         for(Map.Entry<Integer, Integer> entry : ds.size.entrySet()){
//             longest = Math.max(longest, entry.getValue());
//         }
        
//         return longest;
//     }
// }

// class DisjointSet{
//     HashMap<Integer, Integer> id, size;
    
//     public DisjointSet(){
//         this.id = new HashMap<>();
//         this.size = new HashMap<>();
//     }
    
//     public int find(int n){
//         if(id.get(n) == n) return n;
//         id.put(n, find(id.get(n)));
//         return id.get(n);
//     }
    
//     public void union(int u, int v){
//         int idU = find(u);
//         int idV = find(v);
//         if(idU == idV) return;
//         if(size.get(idU) < size.get(idV)){
//             id.put(idU, idV);
//             size.put(idV, size.get(idU) + size.get(idV));
//         } else {
//             id.put(idV, idU);
//             size.put(idU, size.get(idU) + size.get(idV));
//         }
//     }
// }


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int longest = 0;
        
        
        for(int i : set){
            if(set.contains(i - 1)) continue;
            else{
                int count = 1;
                while(set.contains(i+1)){
                    count++;
                    i++;
                }
                
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }
}
