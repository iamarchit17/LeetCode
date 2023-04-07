class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        if(hand.length % k != 0) return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : hand){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : map.keySet()) pq.add(i);
        
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