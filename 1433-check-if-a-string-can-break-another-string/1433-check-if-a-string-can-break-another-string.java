class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            freqS1[s1.charAt(i) - 97]++;
            freqS2[s2.charAt(i) - 97]++;
        }
        
        int i = 0, j = 0;
        char c = 'z';
        int flag = 0;
        while(i < 26 && j < 26){
            if(i - j > 0 && c == 'n') return false;
            else if(i - j < 0 && c == 'p') return false;
            
            if(flag == 0){
                if(i - j < 0){
                    c = 'n';
                    flag = 1;
                } else if(i - j > 0){
                    c = 'p';
                    flag = 1;
                } else c = 'z';
                
            } 
            
            if(freqS1[i] != 0 && freqS2[j] != 0){
                freqS1[i]--;
                freqS2[j]--;
            }
            if(freqS1[i] == 0) i++;
            if(freqS2[j] == 0) j++;
        }
        
        return true;
    }
}