//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int LongestBitonicSequence(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if((nums[j] < nums[i]) && (1 + dp[j] > dp[i])){
                    dp[i] = 1 + dp[j];
                }
            }
        }
        
        // for(int i = 0; i < nums.length; i++) System.out.print(dp[i] + " ");
        // System.out.println();
        
        int[] dpRev = new int[nums.length];
        Arrays.fill(dpRev, 1);
        
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums.length - 1; j > i; j--){
                if((nums[j] < nums[i]) && (1 + dpRev[j] > dpRev[i])){
                    dpRev[i] = 1 + dpRev[j];
                }
            }
        }
        
        // for(int i = 0; i < nums.length; i++) System.out.print(dp[i] + " ");
        // System.out.println();
        
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] + dpRev[i] - 1 > max) max = dp[i] + dpRev[i] - 1;
        }
        
        return max;
    }
}