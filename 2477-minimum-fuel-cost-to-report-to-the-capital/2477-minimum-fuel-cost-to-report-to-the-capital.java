class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < roads.length + 1; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        
        long[] ans = {0L};
        boolean[] visited = new boolean[roads.length + 1];
        dfs(0, adj, visited, seats, ans);
        return ans[0];
        
    }
    
    public int dfs(int node, List<List<Integer>> adj, boolean[] visited, int seats, long[] ans){
        visited[node] = true;
        
        int s = 1;
        for(int i : adj.get(node)){
            if(!visited[i]) s += dfs(i, adj, visited, seats, ans);
        }
         
        if(node != 0) ans[0] += (s % seats == 0) ? s/seats : (s/seats) + 1;
        return s;
    }
}