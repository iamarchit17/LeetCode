class Solution {
    public int largestVariance(String s) {
        int max = 0;
        for(char i = 'a'; i <= 'z'; i++){
            for(char j = 'a'; j <= 'z'; j++){
                if(j != i){
                    int maj = 0, min = 0;
                    for(int k = 0; k < s.length(); k++){
                        if(s.charAt(k) == i) maj++;
                        else if(s.charAt(k) == j) min++;

                        if(min > maj){
                            maj = 0;
                            min = 0;
                        }

                        if(min > 0) max = Math.max(max, maj - min);
                    }
                }
            }
        }
        
        for(char i = 'a'; i <= 'z'; i++){
            for(char j = 'a'; j <= 'z'; j++){
                if(j != i){
                    int maj = 0, min = 0;
                    for(int k = s.length() - 1; k >= 0; k--){
                        if(s.charAt(k) == i) maj++;
                        else if(s.charAt(k) == j) min++;

                        if(min > maj){
                            maj = 0;
                            min = 0;
                        }

                        if(min > 0) max = Math.max(max, maj - min);
                    }
                }
            }
        }
        
        return max;
    }
}