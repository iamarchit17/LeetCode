class Solution {
    public boolean canJump(int[] nums) {
        int till = nums[0];
        int i = 1;
        while(i < nums.length && till >= i){
            if(i + nums[i] > till) till = i + nums[i];
            i++;
        }
        
        return till >= nums.length - 1;
    }
}