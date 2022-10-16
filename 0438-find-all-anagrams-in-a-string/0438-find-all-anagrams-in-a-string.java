class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++){
            if(map.containsKey(p.charAt(i))) map.replace(p.charAt(i), map.get(p.charAt(i)) + 1);
            else map.put(p.charAt(i), 1);
        }
        
        int i = 0, j = 0, count = map.size();
        
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                map.replace(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) count--;
            }
            
            
            if(j - i + 1 == p.length()){
                if(count == 0) list.add(i);
                
                if(map.containsKey(s.charAt(i))){
                    int x = map.get(s.charAt(i));
                    if(x == 0) count++;
                    map.replace(s.charAt(i), x + 1);
                }
                i++;
            }
            j++;
        }
        
        return list;
    }
}