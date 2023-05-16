class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        if(label == 1){
            list.add(1);
            return list;
        }
        
        int level = 0;
        int high = 0;
        while(label > high){
            level++;
            high = high * 2 + 1;
        }
        
        list.add(label);
        while(label > 1){
            level--;
            label = label/2;
            int x = power(2, level) - label;
            int y = power(2, level - 1) + x - 1;
            label = y;
            list.add(y);
        }
        
        for(int i = 0; i < list.size()/2; i++){
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
        
        return list;
    }
    
    public int power(int base, int exp){
        int res = 1;
        while(exp != 0){
            res = res * base;
            exp--;
        }
        
        return res;
    }
}