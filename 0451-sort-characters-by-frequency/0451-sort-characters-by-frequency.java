class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);    
        }
        
       
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(map.size(), (l1, l2) -> l2.getValue() - l1.getValue());
        for(Map.Entry<Character, Integer> entry : map.entrySet()) pq.add(entry);
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() != 0){
            char c = pq.peek().getKey();
            int f = pq.poll().getValue();
            for(int i = 0; i < f; i++) sb.append(c);
        }
        
        return sb.toString();
    }
}