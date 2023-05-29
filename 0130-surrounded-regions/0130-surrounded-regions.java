class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1){
                    if(!visited[i][j] && board[i][j] == 'O') dfs(board, i, j, visited);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, int x, int y, boolean[][] visited){
        visited[x][y] = true;
        
        if(x-1 >= 0 && board[x-1][y] == 'O' && !visited[x-1][y]) dfs(board, x-1, y, visited);
        if(x+1 < board.length && board[x+1][y] == 'O' && !visited[x+1][y]) dfs(board, x+1, y, visited);
        if(y-1 >= 0 && board[x][y-1] == 'O' && !visited[x][y-1]) dfs(board, x, y-1, visited);
        if(y+1 < board[0].length && board[x][y+1] == 'O' && !visited[x][y+1]) dfs(board, x, y+1, visited);
    }
}