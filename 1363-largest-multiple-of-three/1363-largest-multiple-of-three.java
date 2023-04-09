class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] freq = new int[10];
        int sum = 0;
        for(int i : digits){
            freq[i]++;
            sum += i;
        }
        
        int mod = sum % 3;
        
        if(mod != 0){
            boolean deleted = false;
            for(int i = mod; i < 10; i += 3){
                if(freq[i] > 0){
                    freq[i]--;
                    deleted = true;
                    break;
                }
            }

            if(!deleted){
                int del = 2;
                for(int i = 3 - mod; i < 10; i += 3){
                    if(freq[i] >= 2) {
                        freq[i] -= del;
                        break;
                    } else if(freq[i] == 1){
                        freq[i] = 0;
                        del--;
                    }

                    if(del == 0) break;
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            if(i != 0 || sb.length() != 0){
                for(int j = freq[i]; j > 0; j--){
                    sb.append(i);
                }
            }
        }
        
        return (sb.length() == 0 && freq[0] > 0) ? "0" : sb.toString();
        
    }
}