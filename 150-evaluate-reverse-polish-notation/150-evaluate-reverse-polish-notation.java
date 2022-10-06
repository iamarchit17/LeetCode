class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                s.push(s.pop() + s.pop());
            } else if(tokens[i].equals("*")){
                s.push(s.pop() * s.pop());
            } else if(tokens[i].equals("-")){
                int b = s.pop();
                s.push(s.pop() - b);
            } else if(tokens[i].equals("/")){
                int b = s.pop();
                s.push(s.pop()/b);
            } else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return s.peek();
    }
}