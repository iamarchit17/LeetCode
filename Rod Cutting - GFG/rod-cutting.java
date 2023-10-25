//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        return cutRod(price, n, dp);
    }
    
    public int cutRod(int[] price, int n, int[] dp){
        if(n == 0) return 0;
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            int res = price[i-1] + (dp[n-i] == -1 ? cutRod(price, n-1, dp) : dp[n-i]);
            max = Math.max(res, max);
        }
        
        return dp[n] = max;
    }
}