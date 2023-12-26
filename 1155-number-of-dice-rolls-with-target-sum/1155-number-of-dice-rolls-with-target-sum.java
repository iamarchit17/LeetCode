class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        
        for(int i = 1; i < target+1; i++){
            dp[1][i] = (i <= k) ? 1 : 0;
        }
        
        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < target+1; j++){
                for(int x = 1; x <= k; x++){
                    if(j - x >= 1){
                        dp[i][j] += dp[i-1][j-x];
                        dp[i][j] = dp[i][j] % 1000000007;
                    }
                }
            }
        }
        
        return dp[n][target];
    }
}