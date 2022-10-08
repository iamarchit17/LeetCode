class Solution {

    public long subArrayRanges(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            while(!s.empty() && nums[s.peek()] >= nums[i]) s.pop();
            if(s.empty()) left[i] = i + 1;
            else left[i] = i - s.peek();
            s.push(i);
        }
        
        s = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.empty() && nums[s.peek()] > nums[i]) s.pop();
            if(s.empty()) right[i] = nums.length - i;
            else right[i] = s.peek() - i;
            s.push(i);
        }
        
        long minimumSum = 0;
        for(int i = 0; i < nums.length; i++) minimumSum += (1l * left[i] * right[i] * nums[i]);
        
        s = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            while(!s.empty() && nums[s.peek()] <= nums[i]) s.pop();
            if(s.empty()) left[i] = i + 1;
            else left[i] = i - s.peek();
            s.push(i);
        }
        
        s = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.empty() && nums[s.peek()] < nums[i]) s.pop();
            if(s.empty()) right[i] = nums.length - i;
            else right[i] = s.peek() - i;
            s.push(i);
        }
        
        long maximumSum = 0;
        for(int i = 0; i < nums.length; i++) maximumSum +=  (1l * left[i] * right[i] * nums[i]);
        //System.out.println(maximumSum + " " + minimumSum);
        return maximumSum - minimumSum;
        
    }

}