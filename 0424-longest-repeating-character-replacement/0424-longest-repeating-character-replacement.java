class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int j = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) map.replace(c, map.get(c) + 1);
            else map.put(c, 1);
            
            if(map.get(c) > maxFreq) maxFreq = map.get(c);
            
            while(i - j + 1 - maxFreq > k){
                char d = s.charAt(j);
                
                int temp = map.get(d);
                if(temp == 1) map.remove(d);
                else map.replace(d, temp - 1);
                
                if(temp == maxFreq){
                    for(Map.Entry<Character, Integer> entry : map.entrySet()){
                        maxFreq = Math.max(maxFreq, entry.getValue());
                    }
                }
                
                j++;
            }
            
            maxLen = Math.max(maxLen, i - j + 1);
        }
        
        return maxLen;
    }
}