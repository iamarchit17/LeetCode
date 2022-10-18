//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int[] freq = new int[26];
        int max = 0;
        int j = 0, count = 0;
        for(int i = 0; i < S.length(); i++){
            freq[S.charAt(i) - 'a']++;
            if(freq[S.charAt(i) - 'a'] > 1) count++;
            
            while(count > 0) {
                freq[S.charAt(j) - 'a']--;
                if(freq[S.charAt(j) - 'a'] == 1) count--;
                j++;
            }
            
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}