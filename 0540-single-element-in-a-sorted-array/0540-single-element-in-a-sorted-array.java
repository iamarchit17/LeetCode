class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                if(mid % 2 == 0) end = mid - 2;
                else start = mid + 1;
            } else if(mid + 1 < nums.length && nums[mid] == nums[mid + 1]){
                if(mid % 2 == 0) start = mid + 2;
                else end = mid - 1;
            } else{
                start = mid;
                break;
            }
        }
        
        return nums[start];
    }
}