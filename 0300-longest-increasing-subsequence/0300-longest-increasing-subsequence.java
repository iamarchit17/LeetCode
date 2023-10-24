class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return lengthOfLIS(nums, -1, 0, dp);
    }
    
    public int lengthOfLIS(int[] nums, int prev, int idx, int[][] dp){
        if(idx == nums.length) return 0;
        
        if(prev != -1 && dp[prev][idx] != -1) return dp[prev][idx];
        
        int notTaken = lengthOfLIS(nums, prev, idx + 1, dp);
        int taken = 0;
        if(prev == -1 || nums[prev] < nums[idx]) taken = 1 + lengthOfLIS(nums, idx, idx + 1, dp);
        
        if(prev != -1) dp[prev][idx] = Math.max(taken, notTaken);
        return Math.max(taken, notTaken);
    }
}