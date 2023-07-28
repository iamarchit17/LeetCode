class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] subTreeNodes = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        boolean[] visited = new boolean[n];
        int[] dist = {0};
        dfs(0, adj, visited, subTreeNodes, dist, 0);
        
        int[] sumOfDist = new int[n];
        sumOfDist[0] = dist[0];
        Arrays.fill(visited, false);
        sumOfDistances(0, adj, visited, subTreeNodes, sumOfDist, 0);
        
        return sumOfDist;        
    }
    
    public int dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] subTreeNodes, int[] dist, int d){
        visited[node] = true;
        
        dist[0] += d;
        
        int sub = 1;
        for(int i : adj.get(node)){
            if(!visited[i]) sub += dfs(i, adj, visited, subTreeNodes, dist, d + 1);
        }
        
        subTreeNodes[node] = sub;
        return sub;
    }
    
    public void sumOfDistances(int node, List<List<Integer>> adj, boolean[] visited, int[] subTreeNodes, int[] sumOfDist, int d){
        visited[node] = true;
        
        if(node != 0){
            sumOfDist[node] = d - (subTreeNodes[node] - 1);
            sumOfDist[node] = sumOfDist[node] + (adj.size() - (subTreeNodes[node] + 1));
        }
        
        for(int i : adj.get(node)){
            if(!visited[i]) sumOfDistances(i, adj, visited, subTreeNodes, sumOfDist, sumOfDist[node]);
        }

    }
}