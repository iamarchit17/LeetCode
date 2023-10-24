//Memoization
// class Solution {
//     public int maxUncrossedLines(int[] nums1, int[] nums2) {
//         int[][] dp = new int[nums1.length][nums2.length];
//         for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        
//         return maxUncrossedLines(nums1, nums2, 0, 0, dp);
//     }
    
//     public int maxUncrossedLines(int[] nums1, int[] nums2, int idx1, int idx2, int[][] dp){
//         if(idx1 == nums1.length || idx2 == nums2.length) return 0;
        
//         if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
//         if(nums1[idx1] == nums2[idx2]) return dp[idx1][idx2] = 1 + maxUncrossedLines(nums1, nums2, idx1+1, idx2+1, dp);
        
//         return dp[idx1][idx2] = Math.max(maxUncrossedLines(nums1, nums2, idx1+1, idx2, dp), 
//                                          maxUncrossedLines(nums1, nums2, idx1, idx2+1, dp));
//     }
// }

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        Arrays.fill(dp[0], 0);
        for(int i = 0; i < dp.length; i++) dp[i][0] = 0;
        
        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[nums1.length][nums2.length];
    }  
}