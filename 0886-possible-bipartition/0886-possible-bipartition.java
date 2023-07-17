class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < dislikes.length; i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i = 1; i < n+1; i++){
            if(color[i] == -1){
                if(!canBeBipartite(i, 0, adj, color)) return false;
            }
        }
        
        return true;
    }
    
    public boolean canBeBipartite(int node, int currColor, List<List<Integer>> adj, int[] color){
        color[node] = currColor;
        
        for(int nbr : adj.get(node)){
            if(color[nbr] == -1){
                if(!canBeBipartite(nbr, 1 - currColor, adj, color)) return false;
            } else if(color[nbr] == currColor) return false;
        }
        
        return true;
    }
}
