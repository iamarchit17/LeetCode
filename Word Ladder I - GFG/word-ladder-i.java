//{ Driver Code Starts
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
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList){
        HashSet<String> set = new HashSet<>(wordList.length);
        for(int i = 0; i < wordList.length; i++) set.add(wordList[i]);
        
        if(set.contains(startWord)) set.remove(startWord);
        
        Deque<String> dq = new ArrayDeque<>();
        dq.add(startWord);
        int dist = 1;
        
        while(dq.size() != 0){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                String s = dq.poll();
                if(s.equals(targetWord)) return dist;
                char[] c = s.toCharArray();
                
                for(int j = 0; j < s.length(); j++){
                    for(char k = 'a'; k <= 'z'; k++){
                        c[j] = k;
                        String r = String.valueOf(c);
                        if(set.contains(r)){
                            set.remove(r);
                            dq.add(r);
                        }
                    }
                    
                    c[j] = s.charAt(j);
                }
            }
            
            dist++;
        }
        
        return 0;
    }
}