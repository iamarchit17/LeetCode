class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int j = 0;
        long sum = 0;
        long score = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            score = sum * (i - j + 1);
            
            while(score >= k){
                sum -= nums[j];
                j++;
                score = sum * (i - j + 1);
            }
            
            count += (i - j + 1);
        }
        
        return count;
        
    }
}