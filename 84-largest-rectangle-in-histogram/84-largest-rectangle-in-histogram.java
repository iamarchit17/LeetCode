class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!s.empty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.empty()) left[i] = -1;
            else left[i] = s.peek();
            s.push(i);
        }
        
        while(!s.empty()) s.pop();
        
        for(int i = heights.length - 1; i >= 0; i--){
            while(!s.empty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.empty()) right[i] = heights.length;
            else right[i] = s.peek();
            s.push(i);
        }
        
        int max = 0;
        for(int i = 0; i < heights.length; i++) max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        
        return max;
        
    }
}