class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> edges = new ArrayList<>();
        
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                l.add(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                edges.add(l);
            }
        }
        
        Collections.sort(edges, (l1, l2) -> l1.get(2) - l2.get(2));
        
        DisjointSet ds = new DisjointSet(points.length);
        int ans = 0;
        for(int i = 0; i < edges.size(); i++){
            if(ds.find(edges.get(i).get(0)) != ds.find(edges.get(i).get(1))){
                ans += edges.get(i).get(2);
                ds.union(edges.get(i).get(0), edges.get(i).get(1));
            }
        }
        
        return ans;
    }
}

class DisjointSet{
    int[] id, size;
    
    public DisjointSet(int n){
        this.id = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++) id[i] = i;
        Arrays.fill(size, 1);
    }
    
    public int find(int n){
        if(id[n] == n) return n;
        return id[n] = find(id[n]);
    }
    
    public void union(int u, int v){
        int idU = find(u);
        int idV = find(v);
        
        if(idU == idV) return;
        if(size[idU] < size[idV]){
            id[idU] = idV;
            size[idV] += size[idU];
        } else{
            id[idV] = id[idU];
            size[idU] += size[idV];
        }
    }
}