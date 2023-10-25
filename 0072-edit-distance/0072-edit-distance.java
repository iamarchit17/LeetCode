class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        
        return minDistance(word1, word2, 0, 0, dp);
    }
    
    public int minDistance(String word1, String word2, int idx1, int idx2, int[][] dp){
        if(idx1 == word1.length() || idx2 == word2.length()) return Math.max(word1.length() - idx1, word2.length() - idx2);
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(word1.charAt(idx1) == word2.charAt(idx2)) return dp[idx1][idx2] = minDistance(word1, word2, idx1 + 1, idx2 + 1, dp);
        
        int min = Math.min(minDistance(word1, word2, idx1+1, idx2, dp), minDistance(word1, word2, idx1, idx2+1, dp));
        min = Math.min(min, minDistance(word1, word2, idx1+1, idx2+1, dp));
        
        return dp[idx1][idx2] = 1 + min;
    }
}