class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        for(int i = 0; i <= high; i++){
            if(i > low && nums[i] == 0){
                int temp = nums[low];
                nums[low] = 0;
                low++;
                nums[i] = temp;
                i--;
            } else if(nums[i] == 2){
                int temp = nums[high];
                nums[high] = 2;
                high--;
                nums[i] = temp;
                i--;
            }            
        }
    }
}