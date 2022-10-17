class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++){
            if(map.containsKey(s1.charAt(i))) map.replace(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            else map.put(s1.charAt(i), 1);
        }
        
        int i = 0;
        int j = 0;
        int count = map.size();
        
        while(j < s2.length()){
            
            if(map.containsKey(s2.charAt(j))){
                map.replace(s2.charAt(j), map.get(s2.charAt(j)) - 1);
                if(map.get(s2.charAt(j)) == 0) count--;
            }
            
            if(j - i + 1 == s1.length()){
                if(count == 0) return true;
                
                if(map.containsKey(s2.charAt(i))){
                    if(map.get(s2.charAt(i)) == 0) count++;
                    map.replace(s2.charAt(i), map.get(s2.charAt(i)) + 1);
                }
                i++;
            }
            
            j++;
        }
        
        return false;
        
    }
}