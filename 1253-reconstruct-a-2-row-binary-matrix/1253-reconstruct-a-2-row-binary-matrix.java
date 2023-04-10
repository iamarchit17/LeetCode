class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        for(int i = 0; i < colsum.length; i++){
            if(colsum[i] == 2){
                l1.add(1);
                l2.add(1);
                upper--;
                lower--;
            } else if(colsum[i] == 0){
                l1.add(0);
                l2.add(0);
            } else{
                if(upper > lower){
                    l1.add(1);
                    l2.add(0);
                    upper--;
                } else {
                    l1.add(0);
                    l2.add(1);
                    lower--;
                }
            }
            if(upper < 0 || lower < 0) return list;
        }
        
        if(upper > 0 || lower > 0) return list;
        list.add(l1);
        list.add(l2);
        
        return list;
    }
}