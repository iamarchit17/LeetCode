class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[i].length; j++){
                int valid = 0;
                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                        if((i + x) >= 0 && (i + x) < img.length && (j + y) >= 0 && (j + y) < img[0].length){
                            res[i][j] += img[i + x][j + y];
                            valid++;
                        }
                    }
                }
                
                res[i][j] /= valid;
            }
        }
        
        return res;
    }
    
}