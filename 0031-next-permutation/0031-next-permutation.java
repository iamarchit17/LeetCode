class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for(; i >= 0; i--){
            if(nums[i] < nums[i+1]) break;
        }
        
        if(i == -1) Arrays.sort(nums);
        else{
            Arrays.sort(nums, i + 1, nums.length);
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        
    }
}