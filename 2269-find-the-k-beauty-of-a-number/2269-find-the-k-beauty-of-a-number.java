class Solution {
    public int divisorSubstrings(int num, int k) {
        String r = Integer.toString(num);
        int count = 0;
        for(int i = 0; i < r.length() - k + 1; i++){
            int x = Integer.parseInt(r.substring(i, i + k));
            if(x != 0 && num % x == 0) count++;
        }
        
        return count;
    }
}