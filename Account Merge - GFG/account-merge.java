//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        UnionBySize ubs = new UnionBySize(accounts.size());
        
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    ubs.union(i, map.get(accounts.get(i).get(j)));
                } else {
                    map.put(accounts.get(i).get(j), i);
                }    
            }
        }
        
        List<List<String>> merged = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++) merged.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int id = ubs.find(entry.getValue());
            merged.get(id).add(entry.getKey());
        }
        
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            Collections.sort(merged.get(i));
            if(merged.get(i).size() != 0){
                List<String> l = new ArrayList<>();
                l.add(accounts.get(i).get(0));
                for(int j = 0; j < merged.get(i).size(); j++){
                    l.add(merged.get(i).get(j));
                }
                res.add(l);
            }
        }
        
        return res;
    }
}

class UnionBySize{
    int[] id, size;
    
    public UnionBySize(int n){
        this.id = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            id[i] = i;
        }
    }
    
    public int find(int u){
        if(id[u] == u) return u;
        return id[u] = find(id[u]);
    }
    
    public void union(int u, int v){
        int idU = find(u);
        int idV = find(v);
        if(idU == idV) return;
        
        if(size[idU] < size[idV]){
            id[idU] = idV;
            size[idV] += size[idU];
        } else {
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}