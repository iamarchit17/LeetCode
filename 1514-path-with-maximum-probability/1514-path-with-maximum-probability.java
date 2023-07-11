class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<HashMap<Integer, Double>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new HashMap<>());
        
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).put(edges[i][1], succProb[i]);
            adj.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, (l1, l2) -> l2.prob > l1.prob ? 1 : -1);
        pq.add(new Pair(start, 1.0));
        
        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start] = 1.0;
        
        while(pq.size() != 0){
            Pair p = pq.poll();
            int node = p.node;
            double probab = p.prob;
            
            for(Map.Entry<Integer, Double> nbr : adj.get(node).entrySet()){
                double nprob = probab * nbr.getValue();
                if(nprob > prob[nbr.getKey()]){
                    prob[nbr.getKey()] = nprob;
                    pq.add(new Pair(nbr.getKey(), nprob));
                }
            }
        }
        
        return prob[end];
    }
}

class Pair{
    int node;
    double prob;
    
    public Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}