class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])) map.replace(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(arr.length, (l1, l2) -> l1.getValue() - l2.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        
        while(k > 0 && pq.size() > 0){
            int x = pq.peek().getValue();
            if(x <= k){
                k -= x;
                pq.poll();
            } else k = 0; //don't need to change frequency of peek element, as we will require size only and size will not change
        }
        
        return pq.size();
    }
}