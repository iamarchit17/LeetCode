class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] req = new int[nums.length];
        
        for(int[] r : requests){
            req[r[0]]++;
            if(r[1] + 1 < nums.length) req[r[1] + 1]--;
        }
        
        for(int i = 1; i < req.length; i++) req[i] += req[i - 1];
        
        long sum = 0;
        Arrays.sort(req);
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            sum += (( (long) req[i] * (long) nums[i]) % 1000000007);
            sum = sum % 1000000007;
        }
        
        int res = (int)sum;
        
        return res;
    }
}