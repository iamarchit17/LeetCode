class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder newS = new StringBuilder();
        StringBuilder newT = new StringBuilder();
        
        int backspaces = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '#') backspaces++;
            else{
                if(backspaces != 0) backspaces--;
                else newS.append(s.charAt(i));
            }
        }
        
        backspaces = 0;
        
        for(int i = t.length()-1; i >= 0; i--){
            if(t.charAt(i) == '#') backspaces++;
            else{
                if(backspaces != 0) backspaces--;
                else newT.append(t.charAt(i));
            }
        }
        
        return newS.toString().compareTo(newT.toString()) == 0;
    }
}