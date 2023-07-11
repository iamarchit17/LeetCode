class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for(int i = 0; i < edges.length; i++){
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
            dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int thru = 0; thru < n; thru++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][thru] != Integer.MAX_VALUE && dist[thru][j] != Integer.MAX_VALUE){
                        if(dist[i][thru] + dist[thru][j] < dist[i][j]){
                            dist[i][j] = dist[i][thru] + dist[thru][j];
                        }
                    }
                }
            }
        }
        
        int ans = 0;
        int minCities = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int nbrs = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= distanceThreshold) nbrs++;
            }
            if(nbrs <= minCities){
                ans = i;
                minCities = nbrs;
            }
        }
        
        return ans;
    }
}