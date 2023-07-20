class Solution {
    public int search(int[] nums, int target) {
        int smallestIdx = -1;
        int s = 0, e = nums.length - 1;
        
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] > nums[nums.length - 1]) s = mid + 1;
            else e = mid - 1;
        }
        
        int ans = search(nums, target, 0, s-1);
        
        return ans == -1 ? search(nums, target, s, nums.length - 1) : ans;
    }
    
    
    public int search(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                low = mid + 1;
            } else high = mid - 1;
        }
        
        return -1;
    }
}