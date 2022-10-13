class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < k && i < nums.length; i++){
            if(map.containsKey(nums[i])) map.replace(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        
        for(int i = k; i < nums.length; i++){
            if(map.containsKey(nums[i])) map.replace(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
            
            if(map.size() != k + 1) return true;
            
            if(map.get(nums[i-k]) == 1) map.remove(nums[i-k]);
            else map.replace(nums[i-k], map.get(nums[i-k]) - 1);
        }
        
        if(k >= nums.length && map.size() != nums.length) return true;
        
        return false;
    }
}