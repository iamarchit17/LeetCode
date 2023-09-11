class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < groupSizes.length; i++){
            List<Integer> l;
            if(map.containsKey(groupSizes[i])){
                l = map.get(groupSizes[i]);
            } else {
                l = new ArrayList<>();
                map.put(groupSizes[i], l);
            }
            
            l.add(i);
            if(l.size() == groupSizes[i]){
                res.add(new ArrayList<>(l));
                l.clear();
            }
        }
        
        return res;
    }
}