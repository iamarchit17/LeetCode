class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int count = 0;
        int j = -1;
        int prev0 = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
                if(count == 1) prev0 = i;
            }
            
            if(count > 1){
                j = prev0;
                prev0 = i;
                count--;
            }
            
            maxLen = Math.max(maxLen, i - j - 1);
            
        }
        
        if(count == 0) return nums.length - 1;
        return maxLen;
    }
}