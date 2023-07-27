class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        int[] width = new int[heights.length];
        
        for(int i = heights.length - 1; i >= 0; i--){
            while(dq.size() != 0 && heights[dq.peek()] >= heights[i]) dq.pop();
            
            width[i] = dq.size() == 0 ? heights.length : dq.peek();
            dq.push(i);        
        }
        
        
        dq.clear();
        
        for(int i = 0; i < heights.length; i++){
            while(dq.size() != 0 && heights[dq.peek()] >= heights[i]) dq.pop();
            width[i] = dq.size() == 0 ? width[i] : width[i] - dq.peek() - 1;
            dq.push(i);
        }
        
        int largest = 0;
        
        for(int i = 0; i < heights.length; i++) largest = Math.max(largest, heights[i] * width[i]);
        return largest;
    }
}