class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && s.peek() < arr[i]) s.pop();
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        
        s = new ArrayDeque<>();
        
        for(int i = arr.length - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() <= arr[i]) s.pop();
            right[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        
        int minCost = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(left[i] != -1 && right[i] != -1) minCost += (arr[i] * Math.min(left[i], right[i]));
            else minCost += (Math.max(left[i], right[i]) == -1 ? 0 : arr[i] * Math.max(left[i], right[i]));
        }
        
        return minCost;
    }
}