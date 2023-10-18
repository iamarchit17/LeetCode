class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                int max = 0;
                for(int k = -1; k <= 1; k++){
                    for(int l = -1; l <= 1; l++){
                        if(grid[i-k][j-l] > max) max = grid[i-k][j-l];
                    }
                }
                
                res[i-1][j-1] = max;
            }
        }
        
        return res;
    }
}