class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        
        for(int i = 0; i < rowSum.length; i++){
            for(int j = 0; j < colSum.length; j++){
                int e = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = e;
                rowSum[i] -= e;
                colSum[j] -= e;
            }
        }
        
        return matrix;
    }
}