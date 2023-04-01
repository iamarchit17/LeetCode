class Solution {
    public boolean winnerOfGame(String s) {
        if(s.length() < 3) return false;
        int aMoves = 0;
        int bMoves = 0;
        
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A') a++;
            else b++;
            
            if(a == 3) aMoves++;
            if(b == 3) bMoves++;
            
            if(i - 2 >= 0) {
                if(s.charAt(i - 2) == 'A') a--;
                else b--;
            }
        }
        
        return aMoves > bMoves;
    }
}