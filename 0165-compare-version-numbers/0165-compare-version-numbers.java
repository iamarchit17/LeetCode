class Solution {
    public int compareVersion(String version1, String version2) {
        int bi1 = 0;
        int bi2 = 0;
        
        for(; bi1 < version1.length() && bi2 < version2.length();){
            int ei1 = version1.indexOf('.', bi1);
            int ei2 = version2.indexOf('.', bi2);
            
            if(ei1 == -1) ei1 = version1.length();
            if(ei2 == -1) ei2 = version2.length();
            
            int val1 = Integer.valueOf(version1.substring(bi1, ei1));
            int val2 = Integer.valueOf(version2.substring(bi2, ei2));
            
            bi1 = ei1 + 1;
            bi2 = ei2 + 1;
            
            
            if(val1 < val2) return -1;
            else if(val1 > val2) return 1;
        }
        
        while(bi1 < version1.length()){
            int ei1 = version1.indexOf('.', bi1);
            if(ei1 == -1) ei1 = version1.length();
            int val = Integer.valueOf(version1.substring(bi1, ei1));
            if(val > 0) return 1;
            bi1 = ei1 + 1;
        }
        
        while(bi2 < version2.length()){
            int ei2 = version2.indexOf('.', bi2);
            if(ei2 == -1) ei2 = version2.length();
            int val = Integer.valueOf(version2.substring(bi2, ei2));
            if(val > 0) return -1;
            bi2 = ei2 + 1;
        }
        return 0;
    }
}