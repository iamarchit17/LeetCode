class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, HashSet<String>> adj = new HashMap<>();
        
        for(int i = 0; i < recipes.length; i++){
            for(int j = 0; j < ingredients.get(i).size(); j++){
                adj.putIfAbsent(ingredients.get(i).get(j), new HashSet<>());
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
        }
        
        HashMap<String, Integer> inDegree = new HashMap<>();
       for(int i = 0; i < recipes.length; i++){
           inDegree.put(recipes[i], ingredients.get(i).size());
       }
                    
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i < supplies.length; i++){
            q.add(supplies[i]);
            visited.add(supplies[i]);
        }
        
        while(q.size() != 0){
            String supp = q.poll();
            if(adj.containsKey(supp)){
                for(String nb : adj.get(supp)){
                    inDegree.put(nb, inDegree.getOrDefault(nb, 1) - 1);
                    if(inDegree.get(nb) == 0){
                        q.add(nb);
                        visited.add(nb);
                    }
                }
            }
        }
        
        
        List<String> res = new ArrayList<>();
        for(String s : recipes){
            if(visited.contains(s)) res.add(s);
        }
        
        
        return res;
    }
    
}