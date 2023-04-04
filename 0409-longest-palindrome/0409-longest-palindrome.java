class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))) map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }
        
        boolean oddTaken = false;
        int maxLength = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(!oddTaken && entry.getValue() % 2 == 1) oddTaken = true;
            maxLength += (entry.getValue()/2);
        }
        
        return oddTaken ? 2 * maxLength + 1 : 2 * maxLength;
    }
}