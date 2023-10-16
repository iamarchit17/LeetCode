class Solution {
    public int rob(int[] nums) {
        int included = 0;
        int excluded = 0;
        
        for(int i = 0; i < nums.length; i++){
            int newIncluded = excluded + nums[i];
            excluded = Math.max(included, excluded);
            included = newIncluded;
        }
        
        return Math.max(included, excluded);
    }
}