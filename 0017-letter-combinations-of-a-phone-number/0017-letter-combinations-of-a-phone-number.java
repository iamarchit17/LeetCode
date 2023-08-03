class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
        List<String> res = new ArrayList<>();
        letterCombinations(digits, 0, arr, res, new StringBuilder());
        return res;
    }
    
    public void letterCombinations(String digits, int idx, String[] arr, List<String> res, StringBuilder sb){
        if(idx == digits.length()){
            res.add(new StringBuilder(sb).toString());
            return;
        }
        
        for(int i = 0; i < arr[(digits.charAt(idx) - 50)].length(); i++){
            sb.append(arr[digits.charAt(idx) - 50].charAt(i));
            letterCombinations(digits, idx + 1, arr, res, sb);
            sb.replace(sb.length() - 1, sb.length(), "");
        }
    }
}