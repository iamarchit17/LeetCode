class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int last = 1, secondLast = 1;
        
        for(int i = 1; i < s.length(); i++){
            int curr = s.charAt(i) != '0' ? last : 0;
            int x = Integer.valueOf(s.substring(i-1, i+1));
            if(x > 9 && x < 27) curr += secondLast;
            else if(x > 26 && x % 10 == 0) return 0;
            secondLast = last;
            last = curr;
        }
        
        return last;
    }
}