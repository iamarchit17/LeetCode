class Solution {
    public int minPartitions(String n) {
        int x = 0;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) > x) x = n.charAt(i);
            if(n.charAt(i) == 57) return 9;
        }
            
        return x - 48;
    }
}