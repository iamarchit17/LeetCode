//Recursive
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return lengthOfLIS(nums, 0, -1);
//     }
    
//     public int lengthOfLIS(int[] nums, int i, int prevIndex){
//         if(i == nums.length) return 0;
        
//         int notTaken = lengthOfLIS(nums, i+1, prevIndex);
//         int taken = -1;
//         if(prevIndex == -1 || nums[i] > nums[prevIndex]){
//             taken = 1 + lengthOfLIS(nums, i+1, i);
//         }
        
//         return Math.max(taken, notTaken);
//     }
// }

//DP Top-Down

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return lengthOfLIS(nums, 0, -1, dp);
    }
    
    public int lengthOfLIS(int[] nums, int i, int prevIndex, int[][] dp){
        if(i == nums.length) return 0;
        
        if(prevIndex != -1 && dp[i][prevIndex] != -1) return dp[i][prevIndex];
        
        int notTaken = lengthOfLIS(nums, i+1, prevIndex, dp);
        int taken = -1;
        if(prevIndex == -1 || nums[i] > nums[prevIndex]){
            taken = 1 + lengthOfLIS(nums, i+1, i, dp);
        }
        
        if(prevIndex > -1) dp[i][prevIndex] = Math.max(taken, notTaken);
        return Math.max(taken, notTaken);
    }
}