/*
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 1; j <= 26; j++){
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
*/

class Solution {
    public String getSmallestString(int n, int k) {
        char[] str = new char[n];
        for(int i = 0; i < n; i++) str[i] = 'a';
        k -= n;
        
        for(int i = n - 1; i >= 0; i--){
            int min = Math.min(k, 25);
            k -= min;
            str[i] += min;
            if(k == 0) break;
        }

        return String.valueOf(str);
    }
}