class Solution {
    public int countCollisions(String directions) {
        Deque<Character> s = new ArrayDeque<>();
        
        int count = 0;
        for(int i = 0; i < directions.length(); i++){
            char x = directions.charAt(i);
            if(x == 'R') s.push(x);
            else if(x == 'S'){
                while(!s.isEmpty() && s.peek() == 'R'){
                    count++;
                    s.pop();
                }
                s.push('S');
            } else{
                if(s.isEmpty()) continue;

                while(!s.isEmpty() && s.peek() == 'R'){
                    count++;
                    s.pop();
                }
                
                count++;
                s.push('S');
            }       
        }
        
        return count;
    }
}