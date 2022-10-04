class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) s.push(nums[i]);
        
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.empty() && s.peek() <= nums[i]) s.pop();
            if(s.empty()) res[i] = -1;
            else res[i] = s.peek();
            s.push(nums[i]);
        }
        
        return res;
    }
}