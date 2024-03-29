class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> reconstructed = new LinkedList<>();
        for(int i = 0; i < people.length; i++) reconstructed.add(people[i][1], people[i]);
        
        return reconstructed.toArray(new int[people.length][2]);
    }
}