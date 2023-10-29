class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        
        for(int i = 0; i < mat.length; i++){
            int sum = 0;
            for(int j = 0; j < mat[i].length; j++){
                sum += mat[i][j];
            }
            if(sum > res[1]){
                res[0] = i;
                res[1] = sum;
            }
        }
        
        return res;
    }
}