class Solution {
    public int minPartitions(String n) {
        int x = 0;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) > x) x = n.charAt(i);
        }
            
        return x - 48;
    }
}