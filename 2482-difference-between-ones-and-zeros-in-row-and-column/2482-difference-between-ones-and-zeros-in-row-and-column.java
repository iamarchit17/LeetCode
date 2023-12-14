class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] rowOne = new int[n];
        int[] colOne = new int[m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rowOne[i] += grid[i][j];
                colOne[j] += grid[i][j];
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = rowOne[i] + colOne[j] - (n - rowOne[i]) - (m - colOne[j]);
            }
        }
        
        return grid;
    }
}