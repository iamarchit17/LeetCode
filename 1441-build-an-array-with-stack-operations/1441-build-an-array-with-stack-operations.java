class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<String>();
        int p = 0;
        
        for(int i = 1; i <= n; i++){
            if(target[p] == i){
                list.add("Push");
                p++;
            } else if(target[p] != i){
                list.add("Push");
                list.add("Pop");
            }
            
            if(p == target.length) break;
        }
        
        return list;
            
    }
}