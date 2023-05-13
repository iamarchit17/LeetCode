class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            if(i - zero > -1) dp[i] += dp[i - zero];
            if(i - one > -1) dp[i] += dp[i - one];
            
            dp[i] = dp[i] % 1000000007;
        }
        
        long total = 0;
        for(int i = low; i <= high; i++){
            total += dp[i];
            total %= 1000000007;
        }
        
        return (int) total;
    }
}