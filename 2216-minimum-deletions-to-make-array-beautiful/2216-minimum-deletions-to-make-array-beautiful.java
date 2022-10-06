class Solution {
    public int minDeletion(int[] nums) {
        int delete = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            if(!s.empty() && s.size() % 2 == 1 && s.peek() == nums[i]){
                delete++;
                s.pop();
            }
            s.push(nums[i]);
        }
        
        return s.size() % 2 == 1 ? delete+1 : delete;
    }
}