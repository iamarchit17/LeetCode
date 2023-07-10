class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < roads.length; i++){
            List<Integer> l = new ArrayList<>();
            l.add(roads[i][1]);
            l.add(roads[i][2]);
            adj.get(roads[i][0]).add(new ArrayList<>(l));
            l.set(0, roads[i][0]);
            adj.get(roads[i][1]).add(new ArrayList<>(l));
        }
        
        int[] time = new int[n];
        int[] ways = new int[n];
        
        Arrays.fill(time, Integer.MAX_VALUE);
        ways[0] = 1;
        time[0] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, (l1, l2) -> l1.time - l2.time);
        pq.add(new Pair(0, 0));
        
        while(pq.size() != 0){
            Pair p = pq.poll();
            int node = p.node;
            int t = p.time;
            for(List<Integer> nbr : adj.get(node)){
                int cTime = t + nbr.get(1);
                if(cTime < time[nbr.get(0)]){
                    pq.add(new Pair(nbr.get(0), cTime));
                    time[nbr.get(0)] = cTime;
                    ways[nbr.get(0)] = ways[node];
                } else if(cTime == time[nbr.get(0)]) {
                    ways[nbr.get(0)] += ways[node];
                    ways[nbr.get(0)] = ways[nbr.get(0)] % 1000000007;
                }
            }
        }
        
        return ways[n-1];
    }
}

class Pair{
    int node, time;
    
    public Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}