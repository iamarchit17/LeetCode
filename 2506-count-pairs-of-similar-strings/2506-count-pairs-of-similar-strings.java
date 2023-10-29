class Solution {
    public int similarPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            String x = getString(words[i]);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        int ans = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1) ans += ((entry.getValue() * (entry.getValue() - 1))/2);
        }
        
        return ans;
    }
    
    private String getString(String s){
        boolean[] isPresent = new boolean[26];
        for(int i = 0; i < s.length(); i++) isPresent[s.charAt(i) - 97] = true;
        StringBuilder res = new StringBuilder();
        for(char i = 'a'; i <= 'z'; i++){
            if(isPresent[i-97]){
                res.append(i);
            }
        }
        
        return res.toString();
    }
}