//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < roads.size(); i++){
            ArrayList<Integer> l = new ArrayList<>();
            l.add(roads.get(i).get(1));
            l.add(roads.get(i).get(2));
            adj.get(roads.get(i).get(0)).add(l);
            ArrayList<Integer> l1 = new ArrayList<>();
            l1.add(roads.get(i).get(0));
            l1.add(roads.get(i).get(2));
            adj.get(roads.get(i).get(1)).add(l1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, (l1, l2) -> l1.dist - l2.dist);
        int[] ways = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        
        while(pq.size() != 0){
            Pair p = pq.poll();
            int node = p.node;
            int d = p.dist;
            
            if(node == n - 1) return ways[node];
            
            for(ArrayList<Integer> nbr : adj.get(node)){
                int cDist = d + nbr.get(1);
                if(cDist < dist[nbr.get(0)]){
                    dist[nbr.get(0)] = cDist;
                    ways[nbr.get(0)] = ways[node];
                    pq.add(new Pair(cDist, nbr.get(0)));
                } else if(cDist == dist[nbr.get(0)]){
                    ways[nbr.get(0)] += ways[node];
                }
            }
        }
        
        return ways[n-1];
    }
}

class Pair{
    int dist, node;
    
    public Pair(int x, int y){
        this.dist = x;
        this.node = y;
    }
}
