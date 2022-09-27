/*

//Brute Force Solution
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] answer = new int[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 1; j < mat[i].length; j++){
                mat[i][j] = mat[i][j - 1] + mat[i][j];
            }
        }
        
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                for(int s = i - k; s <= i + k; s++){
                    if(s > -1 && s < answer.length){
                        if(j + k < answer[i].length && j - k - 1 > -1){
                            answer[i][j] += mat[s][j + k] - mat[s][j - k - 1]; 
                        } else if(j + k < answer[i].length && j - k - 1 <= -1){
                            answer[i][j] += mat[s][j + k];
                        } else if(j + k >= answer[i].length && j - k - 1 > -1){
                            answer[i][j] += mat[s][answer[i].length - 1] - mat[s][j - k - 1];
                        } else {
                            answer[i][j] += mat[s][answer[i].length - 1];
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
*/

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j != 0){
                    mat[i][j] = mat[i][j - 1] + mat[i][j];
                } else if(i != 0 && j == 0){
                    mat[i][j] = mat[i - 1][j] + mat[i][j];
                } else if(i != 0 && j != 0){
                    mat[i][j] = mat[i - 1][j] + mat[i][j - 1] + mat[i][j] - mat[i - 1][j - 1];
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int p = i - k - 1;
                int q = j - k - 1;
                int r = (i + k >= m) ? (m - 1) : (i + k);
                int s = (j + k >= n) ? (n - 1) : (j + k);
                
                answer[i][j] = mat[r][s];
                if(p > -1) answer[i][j] = answer[i][j] - mat[p][s];
                if(q > -1) answer[i][j] = answer[i][j] - mat[r][q];
                if(p > -1 && q > -1) answer[i][j] += mat[p][q];
            }
        }
        
        return answer;
    }
}