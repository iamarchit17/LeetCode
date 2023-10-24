class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // Arrays.fill(dp[0], 0);
        // for(int i = 0; i < dp.length; i++) dp[i][0] = 0;
        return maxUncrossedLines(nums1, nums2, 0, 0, dp);
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2, int idx1, int idx2, int[][] dp){
        if(idx1 == nums1.length || idx2 == nums2.length) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(nums1[idx1] == nums2[idx2]) return dp[idx1][idx2] = 1 + maxUncrossedLines(nums1, nums2, idx1+1, idx2+1, dp);
        
        return dp[idx1][idx2] = Math.max(maxUncrossedLines(nums1, nums2, idx1+1, idx2, dp), 
                                         maxUncrossedLines(nums1, nums2, idx1, idx2+1, dp));
    }
}