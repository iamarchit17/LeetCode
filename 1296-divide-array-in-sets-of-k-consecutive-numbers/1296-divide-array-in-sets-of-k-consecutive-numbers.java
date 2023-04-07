class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
        }
        
        while(pq.size() != 0){
            int x = pq.peek();
            if(map.get(x) > 0){
                map.replace(x, map.get(x) - 1);        
                for(int i = x + 1; i < x + k; i++){
                    if(!map.containsKey(i) || map.get(i) == 0) return false;
                    map.replace(i, map.get(i) - 1);
                }
            } else {
                pq.poll();
            }
        }
        
        return true;
    }
}