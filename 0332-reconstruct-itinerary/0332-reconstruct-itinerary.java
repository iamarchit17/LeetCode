class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, List<String>> adj = new HashMap<>();
        for(int i = 0; i < tickets.size(); i++){
            if(!adj.containsKey(tickets.get(i).get(0))) adj.put(tickets.get(i).get(0), new ArrayList<String>());
            adj.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        
        for(Map.Entry<String, List<String>> entry : adj.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        List<String> res = new ArrayList<>();
        res.add("JFK");
        
        dfs("JFK", adj, res, new int[]{0}, tickets.size());
        return res;
        
    }
    
    public void dfs(String node, HashMap<String, List<String>> adj, List<String> res, int[] ticketsUsed, int tickets){
        if(!adj.containsKey(node)) return;
        
        List<String> nbrs = adj.get(node);
        for(int i = 0; i < nbrs.size(); i++){
            String nbr = nbrs.get(i);
            nbrs.remove(i);
            
            ticketsUsed[0]++;
            res.add(nbr);
            
            dfs(nbr, adj, res, ticketsUsed, tickets);
            
            if(ticketsUsed[0] == tickets) return;
            
            nbrs.add(i, nbr);
            ticketsUsed[0]--;
            res.remove(res.size() - 1);
        }
    }
}