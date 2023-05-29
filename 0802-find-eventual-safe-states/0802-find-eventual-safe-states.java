
//BFS Solution - Topological Sort on Reverse Graph
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> revAdjList = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) revAdjList.add(new ArrayList<>());
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                revAdjList.get(graph[i][j]).add(i);
            }
        }
        
        int[] inDegree = new int[graph.length];
        for(int i = 0; i < revAdjList.size(); i++){
            for(int x : revAdjList.get(i)) inDegree[x]++;
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> safe = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++){
            if(inDegree[i] == 0) dq.add(i);
        }
        
        while(dq.size() != 0){
            int node = dq.poll();
            safe.add(node);
            
            for(int x : revAdjList.get(node)){
                inDegree[x]--;
                if(inDegree[x] == 0) dq.add(x);
            }
        }
        
        Collections.sort(safe);
        return safe;
    }
}