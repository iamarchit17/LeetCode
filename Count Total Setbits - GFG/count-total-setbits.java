//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long countBits(long N) {
        long ans = 0;
        
        long x = 1;
        int power = 0;
        while(x * 2 - 1 <= N){
            power++;
            x *= 2;
        }
        
        ans = (x * power)/2;
        
        for(long i = x; i <= N; i++){
            long temp = i;
            while(temp > 0){
                ans += (temp % 2);
                temp /= 2;
            }
        }
        
        return ans;
        
    }
}
        
