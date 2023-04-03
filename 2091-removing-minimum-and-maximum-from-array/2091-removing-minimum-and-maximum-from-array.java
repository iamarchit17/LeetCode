class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[maxIndex]) maxIndex = i;
            if(nums[i] < nums[minIndex]) minIndex = i;
        }
        
        int ans = nums.length - (Math.abs(minIndex - maxIndex) - 1);
        ans = Math.min(ans, Math.max(minIndex, maxIndex) + 1);
        
        return Math.min(ans, nums.length - Math.min(minIndex, maxIndex));
        
    }
}