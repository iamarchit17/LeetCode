class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < connections.size(); i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] lowest = new int[n];
        
        dfs(0, adj, visited, time, lowest, bridges, new int[]{0}, -1);
        return bridges;
    }
    
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] time, int[] lowest, List<List<Integer>> bridges, int[] t, int parent){
        visited[node] = true;
        time[node] = t[0];
        lowest[node] = t[0];
        t[0]++;
        for(int nbr : adj.get(node)){
            if(!visited[nbr]){
                dfs(nbr, adj, visited, time, lowest, bridges, t, node);
                if(lowest[nbr] > time[node]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(nbr);
                    bridges.add(bridge);
                } 
                
                lowest[node] = Math.min(lowest[node], lowest[nbr]);
                
            } else if(nbr != parent){
                lowest[node] = Math.min(lowest[node], lowest[nbr]);
            }
        }
    }
}