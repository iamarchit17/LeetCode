class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        
        for(int i = 1; i < strs.length; i++){
            if(strs[i].equals("")) return "";
            for(int j = 0; j < strs[i].length() && j < res.length(); j++){
                if(strs[i].charAt(j) != res.charAt(j)){
                    res = res.substring(0, j);
                    break;
                }
                
                if(j == strs[i].length() - 1) res = strs[i];
            }
        }
        
        return res;
    }
}