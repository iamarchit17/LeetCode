class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (l1, l2) -> l1.getValue() - l2.getValue());
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pq.size() < k) pq.add(entry);
            else{
                if(entry.getValue() > pq.peek().getValue()){
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++) res[i] = pq.poll().getKey();
        
        return res;
    }
}