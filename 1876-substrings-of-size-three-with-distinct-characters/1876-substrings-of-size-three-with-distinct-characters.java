class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        map.put(s.charAt(0), 1);
        if(s.charAt(1) == s.charAt(0)) map.replace(s.charAt(1), 2);
        else map.put(s.charAt(1), 1);
            
        for(int i = 2; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))) map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
            
            if(map.size() == 3) count++;
            
            if(map.get(s.charAt(i-2)) == 1) map.remove(s.charAt(i-2));
            else map.replace(s.charAt(i-2), map.get(s.charAt(i-2)) - 1);
        }
        
        return count;
    }
}