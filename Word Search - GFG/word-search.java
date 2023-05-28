//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution{
    public boolean isWordExist(char[][] board, String word){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, word, 0)) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int x, int y, String word, int index){
        if(index == word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(index) != board[x][y]) return false;
        
        char temp = board[x][y];
        board[x][y] = '_';
        
        if(dfs(board, x-1, y, word, index + 1)) return true;
        if(dfs(board, x+1, y, word, index + 1)) return true;
        if(dfs(board, x, y-1, word, index + 1)) return true;
        if(dfs(board, x, y+1, word, index + 1)) return true;
        
        board[x][y] = temp;
        return false;
    }
}