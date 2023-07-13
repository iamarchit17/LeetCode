class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int[] count = new int[1];
                dfs(i, adj, visited, count);
                list.add(count[0]);
            }
        }
        
        long ans = 0;
        int nodes = n;
        for(int i = 0; i < list.size(); i++){
            ans += (1L * (nodes - list.get(i)) * list.get(i));
            nodes -= list.get(i);
        }
        
        return ans;
    }
    
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] count){
        count[0]++;
        visited[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]) dfs(x, adj, visited, count);
        }
    }
}