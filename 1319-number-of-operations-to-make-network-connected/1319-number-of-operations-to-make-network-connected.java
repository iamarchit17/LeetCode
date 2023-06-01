class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        int cc = 0; //connected components
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                cc++;
                dfs(i, visited, adj);
            }
        }
        
        int cables = connections.length;
        if(cables < n - 1) return -1;
        
        return cc - 1;
        
    }
    
    public void dfs(int node, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]) dfs(x, visited, adj);
        }
    }
}