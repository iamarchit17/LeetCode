class Solution {
    public int minAddToMakeValid(String s) {
        int opener = 0;
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') opener++;
            else {
                if(opener == 0) ans++;
                else opener--;
            }
        }
        
        return ans += opener;
    }
}