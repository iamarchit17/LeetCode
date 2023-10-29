class Solution {
    public int[][] mergeArrays(int[][] items1, int[][] items2) {
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
        
        int[][] arr = new int[res.size()][2];
        for(i = 0; i < arr.length; i++){
            arr[i][0] = res.get(i).get(0);
            arr[i][1] = res.get(i).get(1);
        }
        
        return arr;
    }
}