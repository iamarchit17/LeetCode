class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int i = 0; i < piles.length; i++) Arrays.fill(dp[i], -1);
        
        return stoneGame(piles, 0, piles.length - 1, true, dp) > 0;
        
    }
    
    public int stoneGame(int[] piles, int i, int j, boolean aliceTurn, int[][] dp){
        if(j < i) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(aliceTurn){
            int s1 = piles[i] + stoneGame(piles, i+1, j, !aliceTurn, dp);
            int s2 = piles[j] + stoneGame(piles, i, j-1, !aliceTurn, dp);
            return dp[i][j] = Math.max(s1, s2);
        }
        
        int s1 = stoneGame(piles, i+1, j, !aliceTurn, dp) - piles[i];
        int s2 = stoneGame(piles, i, j-1, !aliceTurn, dp) - piles[j];
        return dp[i][j] = Math.max(s1, s2);
    }
}