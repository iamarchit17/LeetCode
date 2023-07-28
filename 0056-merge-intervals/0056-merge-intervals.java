class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (l1, l2) -> l1[0] - l2[0]);
        int end = intervals[0][1];
        int start = intervals[0][0];
        
        List<List<Integer>> merged = new ArrayList<>();
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > end){
                List<Integer> l = new ArrayList<>();
                l.add(start);
                l.add(end);
                merged.add(l);
                
                start = intervals[i][0];
                end = intervals[i][1];
            } else if(intervals[i][1] > end) end = intervals[i][1];
        }
        
        List<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        merged.add(l);
        
        int[][] res = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++){
            res[i][0] = merged.get(i).get(0);
            res[i][1] = merged.get(i).get(1);
        }
        
        return res;
    }
}