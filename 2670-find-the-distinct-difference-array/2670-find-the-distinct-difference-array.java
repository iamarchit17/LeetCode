class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] res = new int[nums.length];
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            res[i] = set.size();
        }
        set.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] -= set.size();
            set.add(nums[i]);
        }
        
        return res;
    }
}