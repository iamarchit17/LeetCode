class Solution {
    public int clumsy(int n) {
        int fact = 0;
        switch(n){
            case 1:
                fact = 1;
                break;
            case 2: 
                fact = 2;
                break;
            case 3:
                fact = 6;
                break;
            case 4:
                fact = 7;
                break;
            default:
                fact = n + 1;
                int p = fact % 4;
                int x = 0;
                switch(p){
                    case 0:
                        x = -2;
                        break;
                    case 1:
                        x = 0;
                        break;
                    case 2:
                        x = 1;
                    case 3:
                        x = 1;
                        break;
                }
                fact = fact + x;
        }
        
        return fact;
    }
}