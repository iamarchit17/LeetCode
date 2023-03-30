class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int s = nums[0];
        int subs = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - s > k){
                s = nums[i];
                subs++;
            }
        }
        
        return subs;
    }
}