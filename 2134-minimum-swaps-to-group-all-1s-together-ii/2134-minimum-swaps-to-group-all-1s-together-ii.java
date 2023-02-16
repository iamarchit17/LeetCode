class Solution {
    public int minSwaps(int[] nums) {
        int oneCount = 0;
        for(int i = 0; i < nums.length; i++) if(nums[i] == 1) oneCount++;
        
        if(oneCount == 0) return 0;
            
        int j = 0;
        int maxSum = 0;
        int sum = 0;
        
        for(int i = 0; j < nums.length; i++){
            sum += nums[i % nums.length];
            
            if(i - j + 1 == oneCount){
                if(sum > maxSum) maxSum = sum;
                sum -= nums[j];
                j++;
            }
        }
        
        return oneCount - maxSum;
    }
}