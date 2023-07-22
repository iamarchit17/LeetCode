//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String findOrder(String [] dictionary, int N, int K){
        HashMap<Character, List<Character>> adj = new HashMap<>();
        for(int i = 0; i < K; i++){
            adj.put((char)(i + 97), new ArrayList<>());
        }

        for(int i = 1; i < dictionary.length; i++){
            int l = Math.min(dictionary[i-1].length(), dictionary[i].length());
            for(int j = 0; j < l; j++){
                if(dictionary[i].charAt(j) != dictionary[i-1].charAt(j)){
                    adj.get(dictionary[i-1].charAt(j)).add(dictionary[i].charAt(j));
                    break;
                }
            }
        }

        Deque<Character> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[K];
        for(int i = 0; i < K; i++){
            if(!visited[i]) dfs((char) (i + 97), visited, adj, dq);
        }

        StringBuilder res = new StringBuilder();
        while(dq.size() != 0) res.append(dq.pop());

        return res.toString();
    }
    
    
    public void dfs(char node, boolean[] visited, HashMap<Character, List<Character>> adj, Deque<Character> dq){
        visited[node - 97] = true;

        for(char nbr : adj.get(node)){
            if(!visited[nbr - 97]) dfs(nbr, visited, adj, dq);
        }

        dq.push(node);
    }
}