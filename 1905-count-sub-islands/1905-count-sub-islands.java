class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    boolean[] flag = {true};
                    dfs(i, j, grid1, grid2, flag);
                    if(flag[0]) count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int i, int j, int[][] grid1, int[][] grid2, boolean[] flag){
        grid2[i][j] = -1;
        if(grid1[i][j] != 1) flag[0] = false;
        
        if(i - 1 >= 0 && grid2[i-1][j] == 1) dfs(i-1, j, grid1, grid2, flag);
        if(i + 1 < grid2.length && grid2[i + 1][j] == 1) dfs(i+1, j, grid1, grid2, flag);
        if(j - 1 >= 0 && grid2[i][j-1] == 1) dfs(i, j-1, grid1, grid2, flag);
        if(j + 1 < grid2[0].length && grid2[i][j+1] == 1) dfs(i, j+1, grid1, grid2, flag);
    }
}