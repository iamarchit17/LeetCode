class Solution {
    public boolean canConstruct(String s, int k) {
        int odds = 0;
        
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 97]++;
        
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 == 1) odds++;
        }
        
        if(s.length() < k) return false;
        if(odds > k) return false;
        
        return true;
        
    }
}