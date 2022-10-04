class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            while(!s.empty() && j != popped.length && s.peek() == popped[j]){
                s.pop();
                j++;
            }
            
            s.push(pushed[i]);
        }
        
        while(!s.empty() && j != popped.length && s.peek() == popped[j]){
            s.pop();
            j++;
        }
        
        return s.empty();
    }
}