class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length - 1]) return nums[0];
        
        int s = 0, e = nums.length - 1;
        
        while(s < e){
            int mid = s + (e - s)/2;
            
            if(nums[mid+1] < nums[mid]) return nums[mid+1];
            else if(nums[mid] < nums[s]) e = mid;
            else s = mid + 1;
        }
        
        return -1;
    }
}