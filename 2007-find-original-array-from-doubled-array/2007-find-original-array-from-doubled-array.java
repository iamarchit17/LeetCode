class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1) return new int[0];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : changed){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : map.keySet()) pq.add(i);
        
        int[] res = new int[changed.length/2];
        int i = 0;
        while(pq.size() != 0){
            int x = pq.peek();
            if(map.get(x) > 0){
                map.replace(x, map.get(x) - 1);
                if(!map.containsKey(2 * x) || map.get(2 * x) == 0) return new int[0];
                map.replace(2*x, map.get(2 * x) - 1);
                res[i++] = x;
            } else {
                pq.poll();
            }
        }
        
        return res;
    }
}