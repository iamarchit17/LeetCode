class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqNeg = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : map.keySet()){
            if(i > 0) pq.add(i);
            else pqNeg.add(i);
        }
        
        
        while(pqNeg.size() != 0){
            int x = pqNeg.peek();
            
            if(map.get(x) > 0){
                map.replace(x, map.get(x) - 1);
                if(!map.containsKey(2 * x) || map.get(2 * x) == 0) return false;
                map.replace(2 * x, map.get(2 * x) - 1);
            } else {
                pqNeg.poll();
            }
        }
        
        while(pq.size() != 0){
            int x = pq.peek();
            
            if(map.get(x) > 0){
                map.replace(x, map.get(x) - 1);
                if(!map.containsKey(2 * x) || map.get(2 * x) == 0) return false;
                map.replace(2 * x, map.get(2 * x) - 1);
            } else {
                pq.poll();
            }
        }
        
        return true;
    }
}