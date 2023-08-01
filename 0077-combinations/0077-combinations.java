class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();   
        combine(n, k, res, new ArrayList<>());
        return res;
    }
    
    public void combine(int n, int k, List<List<Integer>> res, List<Integer> list){
        if(k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(n < k) return;
        
        combine(n - 1, k, res, list);
        list.add(n);
        combine(n - 1, k - 1, res, list);
        list.remove(list.size() - 1);
    }
}