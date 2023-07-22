//Recursive Solution
// class Solution {
    
//     int[][] moves = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    
//     public double knightProbability(int n, int k, int row, int column) {
//         if(row >= n || row < 0 || column >= n || column < 0) return 0.0;
        
//         if(k == 0) return 1.0;
        
//         double sum = 0.0;
//         for(int i = 0; i < 8; i++){
//             int newRow = row + moves[i][0];
//             int newCol = column + moves[i][1];
//             sum += ((1.0)/8 * knightProbability(n, k-1, newRow, newCol));
//         }
        
//         return sum;
        
//     }
// }

class Solution {
    
    int[][] moves = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1.0);
            }
        }
        
        return knightProbability(n, k, row, column, dp);
    }
    
    
    public double knightProbability(int n, int k, int row, int col, double[][][] dp){
        if(row >= n || row < 0 || col >= n || col < 0) return 0.0;
        
        if(k == 0) return 1.0;
        
        if(dp[row][col][k] != -1.0) return dp[row][col][k];
        
        double sum = 0.0;
        for(int i = 0; i < 8; i++){
            int newRow = row + moves[i][0];
            int newCol = col + moves[i][1];
            sum += ((1.0)/8 * knightProbability(n, k-1, newRow, newCol, dp));
        }
        
        return dp[row][col][k] = sum;
    }
    
}