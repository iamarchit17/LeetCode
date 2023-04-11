class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                dq.pop();
            } else {
                dq.push(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(dq.size() != 0) {
            sb.append(dq.pop());
        }
        
        return sb.reverse().toString();
    }
}