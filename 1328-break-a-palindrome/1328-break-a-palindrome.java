class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch = palindrome.toCharArray();
        
        int flag = 0;
        for(int i = 0; i < palindrome.length()/2; i++){
            if(ch[i] > 'a'){
                ch[i] = 'a';
                flag = 1;
                break;
            }
        }
        
        if(flag == 0 && ch.length != 1) {
            ch[ch.length - 1] = 'b';
            flag = 1;
        }
        
        return flag == 1? String.copyValueOf(ch) : "";
    }
}