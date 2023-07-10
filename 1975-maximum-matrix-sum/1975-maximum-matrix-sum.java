class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negs = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) negs++;
                if(Math.abs(matrix[i][j]) < min) min = Math.abs(matrix[i][j]);
            }
        }
        
        return negs % 2 == 0 ? sum : sum - 2 * min;
    }
}