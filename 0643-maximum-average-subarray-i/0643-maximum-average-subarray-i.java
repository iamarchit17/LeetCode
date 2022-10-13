class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -111111111.0;
        int sum = 0;
        
        for(int i = 0; i < k - 1; i++) sum += nums[i];
        
        for(int i = k - 1; i < nums.length; i++){
            sum += nums[i];
    
            if(1.0*sum/k > max) max = 1.0*sum/k;
            
            sum = sum - nums[i-k+1];
        }
        
        return max;
    }
}