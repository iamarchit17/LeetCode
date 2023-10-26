class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (l1, l2) -> l1[1] - l2[1]);
        
        for(int i = 1; i < pairs.length; i++){
            for(int j = 0; j < i; j++){
                if((pairs[j][1] < pairs[i][0]) && (1 + dp[j] > dp[i])){
                    dp[i] = 1 + dp[j];
                }
            }
        }
        
        int max = 0;
        for(int i : dp){
            if(i > max) max = i;
        }
        
        return max;
    }
}