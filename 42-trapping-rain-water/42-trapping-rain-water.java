/*
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
*/

class Solution {
    public int trap(int[] height) {
        int[] right = new int[height.length];
        int[] left = new int[height.length];
        
        int maxL = height[0];
        left[0] = -1;
        for(int i = 1; i < height.length; i++){
            if(height[i] < maxL) left[i] = maxL;
            else{
                left[i] = -1;
                maxL = height[i];
            }
        }
        
        int maxR = height[height.length - 1];
        right[right.length - 1] = -1;
        for(int i = height.length - 2; i >= 0; i--){
            if(height[i] < maxR) right[i] = maxR;
            else{
                right[i] = -1;
                maxR = height[i];
            }
        }
        
        int trapped = 0;
        for(int i = 0; i < height.length; i++){
            if(right[i] == -1 || left[i] == -1) continue;
            else{
                trapped += (Math.min(right[i], left[i]) - height[i]);
            }
        }
        
        return trapped;
    }
}

