class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= 26; j++){
                //System.out.println(i + " " + j);
                if((j + ((n - 1 - i) * 26)) >= k){
                    k = k - j;
                    char c = (char) (j + 96);
                    sb.append(c);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}