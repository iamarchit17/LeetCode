class Solution {
    public boolean winnerOfGame(String s) {
        if(s.length() < 3) return false;
        int aMoves = 0;
        int bMoves = 0;
        
        for(int i = 0; i < s.length() - 2; i++){
            if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i+1) == s.charAt(i+2)){
                if(s.charAt(i) == 'A') aMoves++;
                else bMoves++;
            }
        }
        
        return aMoves > bMoves;
    }
}