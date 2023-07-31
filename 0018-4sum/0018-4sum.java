class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                for(int j = i + 1; j < nums.length; j++){
                    if(j == (i + 1) || nums[j] != nums[j-1]){
                        int left = j + 1;
                        int right = nums.length - 1;
                        long newTarget = 1L * target;
                        newTarget = newTarget - nums[i] - nums[j];
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]); l.add(nums[j]);

                        while(left < right){
                            if(nums[left] + nums[right] == newTarget){
                                l.add(nums[left]);
                                l.add(nums[right]);
                                list.add(new ArrayList<>(l));
                                l.remove(3); l.remove(2);
                                left++;
                                right--;
                                while(left < nums.length && nums[left] == nums[left - 1]) left++;
                                while(right >= 0 && nums[right] == nums[right + 1]) right--;
                            } else if(nums[left] + nums[right] < newTarget) left++;
                            else right--;
                        }
                    }
                }
            }
        }
        
        return list;
    }
}