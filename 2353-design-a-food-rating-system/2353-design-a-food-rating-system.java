class FoodRatings {
   
    HashMap<String, TreeMap<Integer, TreeSet<String>>> ratingSystem = new HashMap<>();
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, Integer> rat = new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            ratingSystem.putIfAbsent(cuisines[i], new TreeMap<>());
            ratingSystem.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
            ratingSystem.get(cuisines[i]).get(ratings[i]).add(foods[i]);
            map.put(foods[i], cuisines[i]);
            rat.put(foods[i], ratings[i]);
        }
        
//         for(Map.Entry<String, TreeMap<Integer, TreeSet<String>>> entry : ratingSystem.entrySet()){
//             System.out.println(entry.getKey());
//             TreeMap<Integer, TreeSet<String>> tm = entry.getValue();
//             for(Map.Entry<Integer, TreeSet<String>> etr : tm.entrySet()){
//                 System.out.println(etr.getKey() + "    " + etr.getValue());
//             }
//         }
        
//         System.out.println(map);
//         System.out.println(rat);
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = map.get(food);
        int rating = rat.get(food);
        
        ratingSystem.get(cuisine).get(rating).remove(food);
        if(ratingSystem.get(cuisine).get(rating).size() == 0) ratingSystem.get(cuisine).remove(rating);
        ratingSystem.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
        ratingSystem.get(cuisine).get(newRating).add(food);
        
        rat.replace(food, newRating);
        
    }
    
    public String highestRated(String cuisine) {
        //System.out.println(ratingSystem.get(cuisine).lastEntry().getValue().first());
        return ratingSystem.get(cuisine).lastEntry().getValue().first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */