class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (l1, l2) -> l1.getValue() - l2.getValue());
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(entry);
            } else if(pq.size() == k && (entry.getValue() > pq.peek().getValue())){
                pq.poll();
                pq.add(entry);
            }
        }
        
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = pq.poll().getKey();
        }
        
        return arr;
    }
}