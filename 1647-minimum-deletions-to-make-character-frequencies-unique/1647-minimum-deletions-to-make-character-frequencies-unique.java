class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i) - 97]++;
        Arrays.sort(count);
        int ans = 0;
        for(int i = 24; i >= 0; i--){
            if(count[i] != 0){
                if(count[i] >= count[i+1]){
                    if(count[i+1] == 0){
                        ans += count[i];
                        count[i] = 0;
                    } else {
                        ans += (count[i] - count[i+1] + 1);
                        count[i] = count[i+1] - 1;
                    }
                } 
            }
        }
        
        return ans;
    }
}