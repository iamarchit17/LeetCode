class Solution {
    
    public int findMinFibonacciNumbers(int k) {
        
        List<Integer> list = new ArrayList<>();    
        list.add(1);
        list.add(1);
        while(list.get(list.size() - 1) < k){
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        
        int count = 0;
        int j = list.size() - 1;
        while(k > 0){
            if(list.get(j) <= k){
                k = k - list.get(j);
                count++;
            }
            j--;
        }
        
        return count;
    }
}