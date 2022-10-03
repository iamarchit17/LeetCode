class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[prices.length];
        for(int i = prices.length - 1; i >= 0; i--){
            while(!s.empty() && s.peek() > prices[i]) s.pop();
            if(s.empty()) res[i] = prices[i];
            else res[i] = prices[i] - s.peek();
            s.push(prices[i]);
        }
        
        return res;
    }
}