//Recursive Solution
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length() + s2.length() != s3.length()) return false;
//         return isInterleave(s1,s2,s3,0,0,0,false,false);
//     }
    
//     public boolean isInterleave(String s1, String s2, String s3, int idxS1, int idxS2, int idxS3, boolean prevS1, boolean prevS2){
//         if(idxS3 == s3.length()) return true;
        
//         boolean res = false;
//         if(idxS1 < s1.length() && s1.charAt(idxS1) == s3.charAt(idxS3)){
//             if(prevS1) res = res || isInterleave(s1,s2,s3,idxS1+1,idxS2,idxS3+1,prevS1,false);
//             else res = res || isInterleave(s1,s2,s3,idxS1+1,idxS2,idxS3+1,!prevS1,false);
             
//         }
        
//         if(idxS2 < s2.length() && s2.charAt(idxS2) == s3.charAt(idxS3)){
//             if(prevS2) res = res || isInterleave(s1,s2,s3,idxS1,idxS2+1,idxS3+1,false,prevS2);
//             else res = res || isInterleave(s1,s2,s3,idxS1,idxS2+1,idxS3+1,false,!prevS2);
//         }
        
//         return res;
//     }
// }

// Memoization (Top-Down DP)
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length() + s2.length() != s3.length()) return false;
        
//         int[][] dp = new int[s1.length()][s2.length()];
//         for(int i = 0; i < s1.length(); i++) Arrays.fill(dp[i], -1);
        
//         return isInterleave(s1, s2, s3, 0, 0, dp) == 1;
//     }
    
//     public int isInterleave(String s1, String s2, String s3, int idx1, int idx2, int[][] dp){
//         if(idx1 == s1.length()) return (s2.substring(idx2).equals(s3.substring(idx1 + idx2))) ? 1 : 0;
//         if(idx2 == s2.length()) return (s1.substring(idx1).equals(s3.substring(idx1 + idx2))) ? 1 : 0;
//         if(idx1 + idx2 == s3.length()) return (idx1 == s1.length() && idx2 == s2.length()) ? 1 : 0;
        
//         if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
//         int ans = 0;
//         int idx3 = idx1 + idx2;
//         if(s1.charAt(idx1) == s3.charAt(idx3)) ans = ans | isInterleave(s1, s2, s3, idx1 + 1, idx2, dp);
//         if(s2.charAt(idx2) == s3.charAt(idx3)) ans = ans | isInterleave(s1, s2, s3, idx1, idx2 + 1, dp);
        
//         return dp[idx1][idx2] = ans;
        
//     }
// }


//Bottom-Up DP
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length() + s2.length() != s3.length()) return false;
        
//         boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
//         for(int i = 0; i < dp.length; i++){
//             for(int j = 0; j < dp[i].length; j++){
//                 int idx = i + j - 1;
//                 if(i == 0 && j == 0) dp[i][j] = true;
//                 else if(i == 0) dp[i][j] = dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(idx));
//                 else if(j == 0) dp[i][j] = dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(idx));
//                 else dp[i][j] = (s1.charAt(i-1) == s3.charAt(idx) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(idx) && dp[i][j-1]);
//             }
//         }
        
//         return dp[s1.length()][s2.length()];
//     }
// }


//Bottom-Up with Space Optimization
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean[] dp = new boolean[s2.length() + 1];
        boolean[] dp1 = new boolean[s2.length() + 1];
        
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                int idx = i + j - 1;
                if(i == 0 && j == 0) dp[j] = true;
                else if(i == 0) dp[j] = dp[j-1] && (s2.charAt(j-1) == s3.charAt(idx));
                else if(j == 0) dp[j] = dp1[j] && (s1.charAt(i-1) == s3.charAt(idx));
                else dp[j] = (s1.charAt(i-1) == s3.charAt(idx) && dp1[j]) || (s2.charAt(j-1) == s3.charAt(idx) && dp[j-1]);
            }
            
            dp1 = dp.clone();
        }
        
        return dp[s2.length()];
    }
}






















