class Solution {
    public int largestPerimeter(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int sum2side = nums[i] + nums[i + 1];
            for(int j = i + 2; j < nums.length; j++){
                if(sum2side > nums[j]) max = Math.max(max, sum2side + nums[j]);
            }
        }
        
        return max;
    } 
}