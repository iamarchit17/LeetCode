class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<HashSet<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new HashSet<>());
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        
        int maxRank = 0;
        
        for(int i = 0; i < adj.size(); i++){
            for(int j = i+1; j < adj.size(); j++){
                int rank = adj.get(i).size() + adj.get(j).size();
                if(adj.get(i).contains(j)) rank--;
                if(rank > maxRank) maxRank = rank;
            }
        }
        
        return maxRank;
    }
}