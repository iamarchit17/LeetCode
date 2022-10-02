class Solution {
    public int trap(int[] height) {
        int[] right = new int[height.length];
        greatestOnRight(height, right);
        int[] left = new int[height.length];
        greatestOnLeft(height, left);
        
        int trapped = 0;
        for(int i = 0; i < height.length; i++){
            if(right[i] == -1 || left[i] == -1) continue;
            else{
                trapped += (Math.min(right[i], left[i]) - height[i]);
            }
        }
        
        return trapped;
    }
    
    public void greatestOnRight(int[] height, int[] right){
        Stack<Integer> s = new Stack<>();
        
        for(int i = height.length - 1; i >= 0; i--){
            while(!s.empty() && s.peek() <= height[i]) s.pop();
            if(s.empty()){
                right[i] = -1;
                s.push(height[i]);
            } else{
                right[i] = s.peek();
            }
            
        }
    }
    
    public void greatestOnLeft(int[] height, int[] left){
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < height.length; i++){
            while(!s.empty() && s.peek() <= height[i]) s.pop();
            if(s.empty()){
                left[i] = -1;
                s.push(height[i]);
            } else{
                left[i] = s.peek();
            }
            
        }
    }
}