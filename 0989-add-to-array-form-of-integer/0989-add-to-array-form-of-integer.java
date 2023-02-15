class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;
        while(k > 0 && i >= 0){
            int s = num[i] + (k % 10) + carry;
            list.add(0, s % 10);
            carry = s/10;
            k = k /10;
            i--;
        }
        
        while(i >= 0){
            int s = num[i] + carry;
            list.add(0, s%10);
            carry = s/10;
            i--;
        }
        
        while(k > 0){
            int s = k % 10 + carry;
            list.add(0, s%10);
            carry = s/10;
            k = k/10;
        }
        
        if(carry == 1) list.add(0, carry);
        
        return list;
        
    }
}