class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Character, Integer> uniq = new HashMap<>();
        
        for(int size = minSize; size <= maxSize; size++){
            int j = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(uniq.containsKey(c)) uniq.replace(c, uniq.get(c) + 1);
                else uniq.put(c, 1);
                
                if(i - j + 1 == size){
                    if(uniq.size() <= maxLetters){
                        String r = s.substring(j, i+1);
                        if(map.containsKey(r)) map.replace(r, map.get(r) + 1);
                        else map.put(r, 1);
                    }
                    
                    char d = s.charAt(j);
                    if(uniq.get(d) == 1) uniq.remove(d);
                    else uniq.replace(d, uniq.get(d) - 1);
                    j++;
                }
            }
            uniq.clear();
        }
        
        int max = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        
        return max;
    }
}