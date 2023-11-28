class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int count = 0;
        
        for(int i = s.length() - 1; i >= 0; i--){
            //110
            //count = 2
            //carry = 1
            if(i == 0 && carry == 0) continue;
            if(carry == 0 && s.charAt(i) == '1'){
                carry = 1;
                count++;
            } else if(carry == 1 && s.charAt(i) == '0'){
                carry = 1;
                count++;
            }
            count++;
        }
        
        return count;
    }
}