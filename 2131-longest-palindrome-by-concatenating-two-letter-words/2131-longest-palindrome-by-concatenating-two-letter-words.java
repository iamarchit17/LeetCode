class Solution {
    public int longestPalindrome(String[] words) {
        int maxLen = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder(words[i]);
            String str = sb.reverse().toString();
            
            if(map.containsKey(str)){
                if(map.get(str) == 1) map.remove(str);
                else map.replace(str, map.get(str) - 1);
                maxLen += 4;
            } else {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }
        
        for(String key : map.keySet()){
            if(key.charAt(0) == key.charAt(1)){
                maxLen += 2;
                break;
            }
        }
        
        return maxLen;
    }
}