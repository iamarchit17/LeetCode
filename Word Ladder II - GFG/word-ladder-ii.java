//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList){
        HashSet<String> set = new HashSet<>(wordList.length);
        for(String s : wordList) set.add(s);
        
        if(set.contains(beginWord)) set.remove(beginWord);
        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);
        
        Deque<ArrayList<String>> dq = new ArrayDeque<>();
        dq.add(temp);
        boolean flag = false;
        
        while(dq.size() != 0){
            if(!flag){
                int size = dq.size();
                HashSet<String> rem = new HashSet<>();

                for(int i = 0; i < size; i++){
                    ArrayList<String> l = dq.poll();
                    String s = l.get(l.size() - 1);
                    char[] c = s.toCharArray();

                    for(int j = 0; j < c.length; j++){
                        for(char k = 'a'; k <= 'z'; k++){
                            c[j] = k;
                            String r = String.valueOf(c);
                            if(set.contains(r)){
                                if(r.equals(endWord)) flag = true;
                                ArrayList<String> newList = new ArrayList<>(l);
                                newList.add(r);
                                dq.add(newList);
                                rem.add(r);
                            }
                            
                            c[j] = s.charAt(j);
                        }
                    }
                }
                
                for(String s : rem) set.remove(s);
            } else break;
        }
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        while(dq.size() != 0){
            ArrayList<String> l = dq.poll();
            if(l.get(l.size() - 1).equals(endWord)) res.add(l);
        }
        
        return res;
    }
}