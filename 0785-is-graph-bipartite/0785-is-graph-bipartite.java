class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, color,graph)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, int currColor, int[] color, int[][] graph){
        color[node] = currColor;
        
        for(int i : graph[node]){
            if(color[i] == -1){
                if(!dfs(i, 1 - currColor, color, graph)) return false;
            } else if(color[i] == currColor) return false;
        }
        
        return true;
    }
}