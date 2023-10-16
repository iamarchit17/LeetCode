class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = matrix[i][j] - 48;
                if(mat[i][j] == 1) max = 1;
            }
        }
        
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == '1'){
                    mat[i][j] = 1 + Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]);
                    if(mat[i][j] > max) max = mat[i][j];
                }
            }
        }
        
        return max * max;
        
    }
}