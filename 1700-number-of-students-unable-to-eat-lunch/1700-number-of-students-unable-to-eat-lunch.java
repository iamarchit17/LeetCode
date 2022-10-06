class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        int circle = 0, square = 0; 
        for(int i : students) {
            if(i == 0) circle++;
            else square++;
        }
        
        for(int i = 0; i < sandwiches.length; i++){
            if(sandwiches[i] == 0 && circle == 0) return square;
            else if(sandwiches[i] == 1 && square == 0) return circle;
            
            if(sandwiches[i] == 0) circle--;
            else square--;
        }
        
        return 0;
    }
}