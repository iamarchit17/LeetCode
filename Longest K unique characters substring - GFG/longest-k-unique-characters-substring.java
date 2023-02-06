//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int maxLen = -1;
        
        for(int i = 0; i < s.length(); i++){
            
            char x = s.charAt(i);
            if(map.containsKey(x)) map.replace(x, map.get(x) + 1);
            else map.put(x, 1);
            
            while(map.size() > k){
                char y = s.charAt(j);
                if(map.get(y) == 1) map.remove(y);
                else map.replace(y, map.get(y) - 1);
                j++;
            }
            
            if(map.size() == k){
                maxLen = Math.max(maxLen, i - j + 1);
            }
        }
        
        return maxLen;
    }
}