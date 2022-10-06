class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < asteroids.length; i++){
            int x = asteroids[i];
            while(!st.empty() && (-1 *x) > st.peek()) st.pop();
            int y = 0;
            if(!st.empty() && st.peek() == (-1 * x)){
                y = st.peek();
                st.pop();
            }
            
            if(st.empty() && x < 0 && (-1 * x) != y) list.add(x);
            if(x > 0) st.push(x);
            
        }
        
        int[] res = new int[list.size() + st.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        for(int i = res.length - 1; !st.empty(); i--) res[i] = st.pop();
        
        return res;
    }
}