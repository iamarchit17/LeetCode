class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, (l1, l2) -> l1[0] - l2[0]);
        Arrays.sort(items2, (l1, l2) -> l1[0] - l2[0]);
        
        List<List<Integer>> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(true){
            
            
            if(i < items1.length && j < items2.length){
                if(items1[i][0] < items2[j][0]){
                    List<Integer> l = new ArrayList<>();
                    l.add(items1[i][0]);
                    l.add(items1[i][1]);
                    res.add(l);
                    i++;
                } else if(items1[i][0] > items2[j][0]){
                    List<Integer> l = new ArrayList<>();
                    l.add(items2[j][0]);
                    l.add(items2[j][1]);
                    res.add(l);
                    j++;
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(items2[j][0]);
                    l.add(items1[i][1] + items2[j][1]);
                    res.add(l);
                    j++;
                    i++;
                }
            } else if(i < items1.length){
                List<Integer> l = new ArrayList<>();
                l.add(items1[i][0]);
                l.add(items1[i][1]);
                res.add(l);
                i++;
            } else if(j < items2.length){
                List<Integer> l = new ArrayList<>();
                l.add(items2[j][0]);
                l.add(items2[j][1]);
                res.add(l);
                j++;
            } else break;
        }
        
        return res;
    }
}