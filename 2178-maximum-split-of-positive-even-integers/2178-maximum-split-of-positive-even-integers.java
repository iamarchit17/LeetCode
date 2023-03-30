class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if(finalSum % 2 == 1) return list;
        
        for(long i = 2; finalSum > 0; i+=2){
            list.add(i);
            finalSum -= i;
            if(finalSum <= i){
                list.set(list.size() - 1, list.get(list.size() - 1) + finalSum);
                finalSum = 0;
            }
        }
        
        return list;
    }
}