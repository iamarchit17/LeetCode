class Solution {
    public int matrixScore(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 0){
                for(int j = 0; j < grid[i].length; j++) grid[i][j] = 1 - grid[i][j];
            }
        }
        
        for(int j = 0; j < grid[0].length; j++){
            int sum = 0;
            for(int i = 0; i < grid.length; i++) sum += grid[i][j];
            
            if(grid.length - sum > sum){
                for(int i = 0; i < grid.length; i++) grid[i][j] = 1 - grid[i][j];
            }
        }
        
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            int num = 0;
            for(int j = 0; j < grid[i].length; j++){
                num = (grid[i][j] == 1) ? (num << 1) + 1 : (num << 1);
            }
            ans += num;
        }
        
        return ans;
    }
}