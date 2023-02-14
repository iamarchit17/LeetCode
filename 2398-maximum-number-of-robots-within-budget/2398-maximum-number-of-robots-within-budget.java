class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int maxRobots = 0;
        long cost = 0;
        long sum = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        int j = 0;
        for(int i = 0; i < chargeTimes.length; i++){
            sum += runningCosts[i];
            
            while(dq.size() != 0 && dq.peekLast() < chargeTimes[i]){
                dq.removeLast();
            }

            dq.add(chargeTimes[i]);

            cost = (long) (dq.peekFirst()) + ((long)(i - j + 1)) * sum;

            while(cost > budget){
                sum -= runningCosts[j];
                if(dq.peekFirst() == chargeTimes[j]) dq.removeFirst();
                j++;
                if(dq.size() != 0) cost = (long) (dq.peekFirst()) + ((long)(i - j + 1)) * sum;
                else cost = 0;
            }

            if(cost <= budget){
                maxRobots = Math.max(maxRobots, i - j + 1);
            }
        }

        return maxRobots;
    }
}