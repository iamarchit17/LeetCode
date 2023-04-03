class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            res[i] = binarySearch(nums, queries[i]) + 1;
        }
        
        return res;
        
    }
    
    public int binarySearch(int[] nums, int sum){
        int s = 0, e = nums.length - 1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] <= sum && (mid + 1) < nums.length && nums[mid+1] > sum) return mid;
            else if(nums[mid] > sum) e = mid - 1;
            else s = mid + 1;
        }
        
        return e;
    }
}