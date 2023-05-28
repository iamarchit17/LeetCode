class Solution {
    public int[] findOrder(int n, int[][] preqs) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < preqs.length; i++) adj.get(preqs[i][1]).add(preqs[i][0]);
        
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            if(!visited[i]) dfs(i, visited, path, dq, adj);
        }
        
        if(dq.size() < n) return new int[0];
        
        int[] order = new int[n];
        for(int i = 0; i < n; i++) order[i] = dq.pop();
        
        return order;
    }
    
    public boolean dfs(int node, boolean[] visited, boolean[] path, Deque<Integer> dq, ArrayList<ArrayList<Integer>> adj){
        
        visited[node] = true;
        path[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]){
                if(dfs(x, visited, path, dq, adj)) return true;
            } else if(path[x]) return true;
        }
        
        path[node] = false;
        dq.push(node);
        
        return false;
    }
}