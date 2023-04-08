class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int points = 0;
        int[][] reward = new int[reward1.length][2];
        for(int i = 0; i < reward.length; i++){
            reward[i][0] = reward1[i];
            reward[i][1] = reward2[i];
        }
        
        Arrays.sort(reward, (l1, l2) -> (l2[0] - l2[1]) - (l1[0] - l1[1]));
        
        for(int i = 0; i < reward.length; i++){
            points += (i < k ? reward[i][0] : reward[i][1]);
        }
        
        return points;
    }
}