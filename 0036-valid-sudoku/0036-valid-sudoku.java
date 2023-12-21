class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();
        List<HashSet<Integer>> grid = new ArrayList<>();
        
        for(int i = 0; i < 9; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grid.add(new HashSet<>());
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int x = board[i][j] - 48;
                    if(rows.get(i).contains(x)) return false;
                    else rows.get(i).add(x);
                    
                    if(cols.get(j).contains(x)) return false;
                    else cols.get(j).add(x);
                    
                    if(grid.get(3 * (i/3) + (j/3)).contains(x)) return false;
                    else grid.get(3 * (i/3) + (j/3)).add(x);
                }
            }
        }
        
        return true;
    }
}