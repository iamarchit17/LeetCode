class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        int n = rowIndex;
        
        for(int i = 0; i < rowIndex; i++){
            long ele = 1 * list.get(i);
            ele = ele * n;
            ele = ele/(i + 1);
            
            list.add((int)(ele));
            n--;
        }
        
        return list;
    }
}