class Solution {
    public int maxSumMinProduct(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
            while(!s.empty() && nums[s.peek()] >= nums[i]) s.pop();
            left[i] = (s.empty()) ? 0 : s.peek() + 1; 
            s.push(i);
        }
        
        s= new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!s.empty() && nums[s.peek()] >= nums[i]) s.pop();
            right[i] = (s.empty()) ? nums.length - 1 : s.peek() - 1; 
            s.push(i);
        }
        
        
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) sum[i] = sum[i-1] + nums[i];
        
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            long subArraySum = sum[right[i]] - ((left[i] == 0) ? 0 : sum[left[i] - 1]);
            long minProd = subArraySum * nums[i];
            if(minProd > max) max = minProd; 
        }
        
        return (int)(max % 1000000007);
    }
}