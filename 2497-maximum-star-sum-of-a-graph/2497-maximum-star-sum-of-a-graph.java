class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            if(vals[edges[i][1]] > 0){
                if(map.containsKey(edges[i][0])){
                    if(map.get(edges[i][0]).size() < k) map.get(edges[i][0]).add(vals[edges[i][1]]);
                    else if(map.get(edges[i][0]).peek() < vals[edges[i][1]]){
                        map.get(edges[i][0]).poll();
                        map.get(edges[i][0]).add(vals[edges[i][1]]);
                    }
                } else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(vals[edges[i][1]]);
                    if(k != 0) map.put(edges[i][0], pq);
                }
            } 
            
            if(vals[edges[i][0]] > 0){
                if(map.containsKey(edges[i][1])){
                    if(map.get(edges[i][1]).size() < k) map.get(edges[i][1]).add(vals[edges[i][0]]);
                    else if(map.get(edges[i][1]).peek() < vals[edges[i][0]]){
                        map.get(edges[i][1]).poll();
                        map.get(edges[i][1]).add(vals[edges[i][0]]);
                    }
                } else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(vals[edges[i][0]]);
                    if(k != 0) map.put(edges[i][1], pq);
                }
            } 
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < vals.length; i++){
            int sum = vals[i];
            if(map.containsKey(i)){
                while(map.get(i).size() != 0) sum += map.get(i).poll();
            }
            if(sum > max) max = sum;
        }
        
        return max;
    }
}