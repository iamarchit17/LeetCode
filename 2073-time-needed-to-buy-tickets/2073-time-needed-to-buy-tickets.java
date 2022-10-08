class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int num = tickets[k];
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i] < num) time += tickets[i];
            else time += (i > k ? num - 1 : num);
        }
        
        return time;
    }
}