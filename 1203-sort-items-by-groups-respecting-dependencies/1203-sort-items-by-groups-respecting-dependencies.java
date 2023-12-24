class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int nextAvailable = m;
        for(int i = 0; i < group.length; i++){
            int x = group[i] == -1 ? nextAvailable++ : group[i];
            map.put(i, x);
        }
        
        List<HashSet<Integer>> groupAdj = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, HashSet<Integer>>> withinGroupAdj = new HashMap<>();
        
        for(int i = 0; i < nextAvailable; i++){
            groupAdj.add(new HashSet<>());
            withinGroupAdj.put(i, new HashMap<>());
        }
        
        for(int i = 0; i < n; i++){
            int g = map.get(i);
            withinGroupAdj.get(g).put(i, new HashSet<>());
        }
        
        for(int i = 0; i < beforeItems.size(); i++){
            int g1 = map.get(i);
            for(int j : beforeItems.get(i)){
                int g2 = map.get(j);
                if(g1 != g2) groupAdj.get(g2).add(g1);
                else{
                    withinGroupAdj.get(g1).get(j).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[nextAvailable];
        boolean[] path = new boolean[nextAvailable];
        Deque<Integer> dqGroup = new ArrayDeque<>();
        
        for(int i = 0; i < nextAvailable; i++){
            if(!visited[i]){
                if(dfs(i, visited, path, groupAdj, dqGroup)) return new int[0];
            }
        }
        
        
        int[] res = new int[n];
        int idx = 0;
        
        while(dqGroup.size() != 0){
            int g = dqGroup.pop();
            HashMap<Integer, HashSet<Integer>> wga = withinGroupAdj.get(g);
            HashSet<Integer> v = new HashSet<>();
            HashSet<Integer> p = new HashSet<>();
            Deque<Integer> d = new ArrayDeque<>();
            
            for(int x : wga.keySet()){
                if(!v.contains(x)){
                    if(dfs(x, v, p, wga, d)) return new int[0];
                }
            }
            
            while(d.size() != 0){
                res[idx++] = d.pop();
            }   
        }
        
        return res;
    }
    
    public boolean dfs(int node, boolean[] visited, boolean[] path, List<HashSet<Integer>> adj, Deque<Integer> dq){
        visited[node] = true;
        path[node] = true;
        
        for(int nbr : adj.get(node)){
            if(!visited[nbr]){
                if(dfs(nbr, visited, path, adj, dq)) return true;
            } else if(path[nbr]) return true;
        }
        
        dq.push(node);
        path[node] = false;
        return false;
    }
    
    public boolean dfs(int node, HashSet<Integer> visited, HashSet<Integer> path, HashMap<Integer, HashSet<Integer>> adj, Deque<Integer> dq){
        visited.add(node);
        path.add(node);
        
        for(int nbr : adj.get(node)){
            if(!visited.contains(nbr)){
                if(dfs(nbr, visited, path, adj, dq)) return true;
            } else if(path.contains(nbr)) return true;
        }
        
        dq.push(node);
        path.remove(node);
        return false;
    }
}