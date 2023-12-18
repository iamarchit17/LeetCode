class Solution {
    public int maxProductDifference(int[] nums) {
        int max = nums[0];
        int secondMax = 0;
        int min = nums[0];
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= max){
                secondMax = max;
                max = nums[i];
            } else if(nums[i] > secondMax && nums[i] < max){
                secondMax = nums[i];
            }
            
            if(nums[i] <= min){
                secondMin = min;
                min = nums[i];
            } else if(nums[i] < secondMin && nums[i] > min){
                secondMin = nums[i];
            }
        }
        
        return (max * secondMax) - (min * secondMin);
    }
}