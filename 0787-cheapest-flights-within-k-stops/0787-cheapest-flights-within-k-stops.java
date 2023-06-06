class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < flights.length; i++){
            ArrayList<Integer> l = new ArrayList<>();
            l.add(flights[i][1]);
            l.add(flights[i][2]);
            adj.get(flights[i][0]).add(l);
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        dq.add(new int[]{0, src, 0});
        
        while(dq.size() != 0){
            int[] arr = dq.poll();
            int node = arr[1];
            int stops = arr[0];
            int c = arr[2];
            
            for(ArrayList<Integer> l : adj.get(node)){
                if(stops < k+1 && c + l.get(1) < cost[l.get(0)]){
                    cost[l.get(0)] = c + l.get(1);
                    dq.add(new int[]{stops+1, l.get(0), cost[l.get(0)]});
                }
            }
        }
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}