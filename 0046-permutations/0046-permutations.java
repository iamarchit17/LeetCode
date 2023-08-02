class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }
    
    public void permute(int[] nums, int idx, List<List<Integer>> res){
        if(idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) list.add(nums[i]);
            res.add(list);
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
            
            permute(nums, idx+1, res);
            
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }
}