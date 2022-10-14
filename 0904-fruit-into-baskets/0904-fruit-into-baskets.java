class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        
        for(int i = 0; i < fruits.length; i++){
            if(map.containsKey(fruits[i])) map.replace(fruits[i], map.get(fruits[i]) + 1);
            else map.put(fruits[i], 1);
            
            while(map.size() > 2) {
                if(map.get(fruits[j]) == 1) map.remove(fruits[j]);
                else map.replace(fruits[j], map.get(fruits[j]) - 1);
                j++;
            } 
            maxFruits = Math.max(maxFruits, i - j + 1);
        }
        
        return maxFruits;
    }
}