//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countOfSubstrings(S,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countOfSubstrings(String S, int K) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int ans = 0;
        
        while(j < S.length()){
            if(!map.containsKey(S.charAt(j))) map.put(S.charAt(j), 1);
            else map.replace(S.charAt(j), map.get(S.charAt(j)) + 1);
            
            if(j - i + 1 == K){
                if(map.size() == K - 1) ans++;
                
                if(map.get(S.charAt(i)) == 1) map.remove(S.charAt(i));
                else map.replace(S.charAt(i), map.get(S.charAt(i)) - 1);
                i++;
            }
            
            j++;
        }
        
        return ans;
    }
}