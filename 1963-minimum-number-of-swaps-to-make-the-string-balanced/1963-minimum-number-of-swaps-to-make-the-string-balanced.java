class Solution {
    public int minSwaps(String s) {
        int fault = 0, open = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '[') open++;
            else{
                if(open == 0) fault++;
                else open--;
            }
        }
        
        return (fault+1)/2;
    }
}