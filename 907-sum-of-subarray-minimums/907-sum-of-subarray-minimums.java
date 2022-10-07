class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s = new Stack<>();
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];
        
        
        for(int i = 0; i < arr.length; i++){
            while(!s.empty() && arr[s.peek()] >= arr[i]) s.pop();
            if(s.empty()) left[i] = i + 1;
            else left[i] = i - s.peek();
            s.push(i);
        }
        
        while(!s.empty()) s.pop();
        
        for(int i = arr.length - 1; i >= 0; i--){
            while(!s.empty() && arr[s.peek()] > arr[i]) s.pop();
            if(s.empty()) right[i] = arr.length - i;
            else right[i] = s.peek() - i;
            s.push(i);
        }
        
        long res = 0;
        for(int i = 0; i < arr.length; i++){
            long x = left[i] * right[i] * arr[i];
            res = res + x;
            res = res % 1000000007;
        }
        
        return (int) res;
    }
}