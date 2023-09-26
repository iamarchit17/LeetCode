class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        
        for(int i = 0; i < s.length(); i++){
            if(!visited[s.charAt(i) - 97]){
                while(dq.size() != 0 && freq.get(dq.peek()) != 0  && dq.peek() >= s.charAt(i)){
                    visited[dq.peek() - 97] = false;
                    dq.pop();
                }

                dq.push(s.charAt(i)); 
                visited[dq.peek() - 97] = true;
            }
            
            freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        while(dq.size() != 0) sb.append(dq.pop());
        
        return sb.reverse().toString();
    }
}