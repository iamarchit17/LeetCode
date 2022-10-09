class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int time = 0;
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0; i < logs.size(); i++){
            boolean start = true;
            if(logs.get(i).contains("end")) start = false;
            
            int id = Integer.parseInt(logs.get(i).substring(0, logs.get(i).indexOf(':')));
            int timestamp = Integer.parseInt(logs.get(i).substring(logs.get(i).lastIndexOf(':') + 1, logs.get(i).length()));
            
            if(start){
                if(!st.isEmpty()) res[st.peek()] += (timestamp - time);
                st.push(id);
            } else {
                timestamp = timestamp + 1;
                res[id] += timestamp - time;
                st.pop();
            }           
            
            time = timestamp;
            
        }
        
        return res;
    }
}