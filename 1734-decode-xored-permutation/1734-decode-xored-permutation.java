class Solution {
    public int[] decode(int[] encoded) {
        int xor = 0;
        if((encoded.length/2) % 2 == 0) xor = 1;
        
        for(int i = 1; i < encoded.length; i += 2) xor ^= encoded[i];
        
        int[] arr = new int[encoded.length + 1];
        arr[0] = xor;
        for(int i = 1; i < arr.length; i++) arr[i] = arr[i-1] ^ encoded[i-1];
        
        return arr;
    }
}