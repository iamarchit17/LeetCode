class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < rocks.length; i++) pq.add(capacity[i] - rocks[i]);
        // System.out.println(pq);
        int count = 0;
        while(additionalRocks > 0){
            if(pq.size() == 0) break;
            else{
                if(pq.peek() <= additionalRocks){
                    count++;
                    additionalRocks -= pq.poll();
                } else break;
            }
        }
        
        return count;
    }
}