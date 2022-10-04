class BrowserHistory {
    ArrayList<String> history;
    int size;
    int curr;
    
    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        history.add(homepage);
        this.size = 1;
        this.curr = 0;
    }
    
    public void visit(String url) {
        ++curr;
        if(curr == history.size()){
            history.add(url);
            size++;
        } else{
            history.set(curr, url);
            size = curr+1;
        }
    }
    
    public String back(int steps) {
        curr = (curr - steps) >= 0 ? (curr - steps) : 0;
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = (curr + steps) < size ? (curr + steps) : size - 1;
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */