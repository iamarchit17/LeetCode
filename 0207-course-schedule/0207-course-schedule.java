class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);        
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, path)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]){
                if(dfs(x, adj, visited, path)) return true;
            } else if(path[x]) return true;
        }
        
        path[node] = false;
        return false;
    }
}