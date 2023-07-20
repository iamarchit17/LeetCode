class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0) dq.push(asteroids[i]);
            else{
                while(true){
                    if(dq.size() == count){
                        count++;
                        dq.push(asteroids[i]);
                        break;
                    } else if(dq.size() > count && dq.peek() < -1 * asteroids[i]){
                        dq.pop();
                    } else if(dq.size() > count && dq.peek() == -1 * asteroids[i]){
                        dq.pop();
                        break;
                    } else break;
                }
            }
        }
        
        int[] res = new int[dq.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = dq.pop();
        }
        
        return res;
    }
}