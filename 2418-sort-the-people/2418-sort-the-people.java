class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[][] sorted = new String[names.length][2];
        
        for(int i = 0; i < names.length; i++){
            sorted[i][0] = names[i];
            sorted[i][1] = String.valueOf(heights[i]);
        }
        
        Arrays.sort(sorted, (l1, l2) -> Integer.valueOf(l1[1]) - Integer.valueOf(l2[1]));
        
        String[] res = new String[names.length];
        
        for(int i = names.length - 1; i >= 0; i--){
            res[i] = sorted[names.length - i - 1][0];
        }
        
        return res;
    }
}