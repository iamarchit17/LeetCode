class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for(; i >= 0; i--){
            if(nums[i] < nums[i+1]) break;
        }
        
        if(i == -1) {
            for(int j = 0; j < nums.length/2; j++){
                int temp = nums[j];
                nums[j] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = temp;
            }
        }
        else{
            int beginIndex = i + 1;
            int k = 0;
            for(int j = 0; j < (nums.length - beginIndex)/2; j++){
                int temp = nums[j + beginIndex];
                nums[j + beginIndex] = nums[nums.length - 1 - k];
                nums[nums.length - 1 - k] = temp;
                k++;
            }
            
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