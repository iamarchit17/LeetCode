class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
    
        int[] inDegree = new int[n+1];
        for(int i = 0; i < relations.length; i++){
            adj.get(relations[i][0]).add(relations[i][1]);
            inDegree[relations[i][1]]++;
        }
         
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, (l1, l2) -> l1.end - l2.end);
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                pq.add(new Pair(i, time[i-1]));
            }
        }
        
        int minTime = 0;
        
        while(pq.size() != 0){
            Pair p = pq.poll();
            if(p.end > minTime) minTime = p.end;
            for(int nbr : adj.get(p.x)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0){
                    pq.add(new Pair(nbr, p.end + time[nbr - 1]));
                }
            }
        }
        
        return minTime;
    }
}


class Pair{
    int x;
    int end;
    
    public Pair(int x, int end){
        this.x = x;
        this.end = end;
    }
}