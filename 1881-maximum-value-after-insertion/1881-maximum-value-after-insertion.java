class Solution {
    public String maxValue(String n, int x) {
        char c = (char) (x + 48);
        StringBuilder sb = new StringBuilder();
        
        if(n.charAt(0) == '-'){
            sb.append('-');
            boolean appended = false;
            for(int i = 1; i < n.length(); i++){
                if(!appended && n.charAt(i) > c){
                    sb.append(c);
                    appended = true;
                }
                sb.append(n.charAt(i));
            }
            if(!appended) sb.append(c);
        } else {
            boolean appended = false;
            for(int i = 0; i < n.length(); i++){
                if(!appended && n.charAt(i) < c){
                    sb.append(c);
                    appended = true;
                }
                sb.append(n.charAt(i));
            }
            if(!appended) sb.append(c);
        }
        
        return sb.toString();
    }
}