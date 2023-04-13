class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        int j = 0;
        for(int i = 0; i < pushed.length && j < popped.length;){
            if(dq.size() != 0 && dq.peek() == popped[j]){
                dq.pop();
                j++;
            } else {
                dq.push(pushed[i]);
                i++;
            }
        }
        
        while(dq.size() > 0 && j < popped.length){
            if(dq.poll() == popped[j]) j++;
            else return false;
        }
        
        return dq.size() == 0;
    }
}