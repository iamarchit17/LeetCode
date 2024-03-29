class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        
        int marked = 0;
        
        int j = nums.length/2;
        for(int i = 0; i < nums.length/2; i++){
            if(j == nums.length) break;
            if(2 * nums[i] <= nums[j]) marked += 2;
            else i--;
            j++;
        }
        
        return marked;
    }
}