class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        
        boolean[] visited = new boolean[graph.length];
        List<Integer> p = new ArrayList<>();
        dfs(0, graph, paths, p, visited);
        
        return paths;
    }
    
    public void dfs(int node, int[][] graph, List<List<Integer>> paths, List<Integer> p, boolean[] visited){
        visited[node] = true;
        p.add(node);
        if(node == graph.length - 1){
            paths.add(new ArrayList<>(p));
            p.remove(p.size() - 1);
            visited[node] = false;
            return;
        }
        
        for(int nbr : graph[node]){
            if(!visited[nbr]) dfs(nbr, graph, paths, p, visited); 
        }
        
        p.remove(p.size() - 1);
        visited[node] = false;
    }
}