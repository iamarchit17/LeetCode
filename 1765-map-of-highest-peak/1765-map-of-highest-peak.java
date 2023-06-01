class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Deque<int[]> dq = new ArrayDeque<>();
        
        int n = isWater.length;
        int m = isWater[0].length;
        
        int[][] height = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(height[i], -1);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isWater[i][j] == 1){
                    dq.add(new int[]{i, j});
                    height[i][j] = 0;
                }
            }
        }
        
        int dist = 1;
        while(dq.size() != 0){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                int[] node = dq.poll();
                int x = node[0];
                int y = node[1];
                
                if(x-1 >= 0 && isWater[x-1][y] == 0 && height[x-1][y] == -1){
                    height[x-1][y] = dist;
                    dq.add(new int[]{x-1, y});
                }
                
                if(x+1 < n && isWater[x+1][y] == 0 && height[x+1][y] == -1){
                    height[x+1][y] = dist;
                    dq.add(new int[]{x+1, y});
                }
                
                if(y-1 >= 0 && isWater[x][y-1] == 0 && height[x][y-1] == -1){
                    height[x][y-1] = dist;
                    dq.add(new int[]{x, y-1});
                }
                
                if(y+1 < m && isWater[x][y+1] == 0 && height[x][y+1] == -1){
                    height[x][y+1] = dist;
                    dq.add(new int[]{x, y+1});
                }
            }
            dist++;
        }
        
        return height;
    }
}