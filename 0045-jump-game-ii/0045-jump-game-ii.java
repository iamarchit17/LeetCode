class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] >= (i - j) && dp[j] + 1 < dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}