class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])) map.replace(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry.getValue());
        }
        
        while(k > 0) k -= pq.poll(); //since k can be maximum equal to arr.length, we don't need to check if pq will be empty or not
            
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}