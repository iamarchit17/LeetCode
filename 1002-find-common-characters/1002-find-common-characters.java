class Solution {
    public List<String> commonChars(String[] words) {
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            int[] freq = new int[26];
            for(int j = 0; j < s.length(); j++){
                freq[s.charAt(j) - 97]++;
            }
            
            for(int j = 0; j < 26; j++){
                min[j] = Math.min(min[j], freq[j]);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(char i = 'a'; i <= 'z'; i++){
            for(int j = 0; j < min[i-97]; j++){
                res.add(String.valueOf(i));
            }
        }
        
        return res;
    }
}