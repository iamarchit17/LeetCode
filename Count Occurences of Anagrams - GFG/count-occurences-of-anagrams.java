//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(String pat, String txt) {
        int k = pat.length();
        
        int[] count = new int[26];
        for(int i = 0; i < pat.length(); i++) count[pat.charAt(i) - 97]++;
        
        int[] countSub = new int[26];
        
        int ans = 0;
        
        for(int i = 0; i < txt.length(); i++){
            countSub[txt.charAt(i) - 97]++;
            
            if(i >= k-1){
                boolean flag = true;
                for(int j = 0; j < 26; j++){
                    if(count[j] != countSub[j]){
                        flag = false;
                        break;
                    }
                }
                
                if(flag) ans++;
                countSub[txt.charAt(i-k+1) - 97]--;
            }
        }
        
        return ans;
        
    }
}