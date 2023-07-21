class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < heights.length - 1; i++){
            if(heights[i] < heights[i+1]){
                int diff = heights[i+1] - heights[i];
                if(pq.size() < ladders) pq.add(diff);
                else if(pq.size() == ladders){
                    if(ladders == 0){
                        bricks = bricks - diff;
                    } else {
                        if(diff > pq.peek()){
                            bricks -= pq.poll();
                            pq.add(diff);
                        } else {
                            bricks -= diff;
                        }
                    }
                }
                
                if(bricks < 0) return i;
                
            }
        }
        
        return heights.length - 1;
    }
}