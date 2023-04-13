class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashSet<Integer> indices = new HashSet<>();
        int minRots = tops.length + 1;
        for(int i = 1; i <= 6; i++){
            int countTops = 0;
            for(int j = 0; j < tops.length; j++){
                if(tops[j] == i){ 
                    indices.add(j);
                    countTops++;
                }
            }
            
            int countBottom = 0;
            int count = 0;
            for(int j = 0; j < bottoms.length; j++){
                if(!indices.contains(j) && bottoms[j] == i) count++;
                if(bottoms[j] == i) countBottom++;
            }
            
            //System.out.println(indices.size() + " " + count);
            if(count + indices.size() == tops.length) minRots = tops.length - Math.max(countTops, countBottom);
            indices.clear();
        }
        
        return minRots == tops.length + 1 ? -1 : minRots;
    }
}