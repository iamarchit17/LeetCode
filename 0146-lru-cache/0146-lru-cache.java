class LRUCache {
    class Node{
        int key, value;
        Node next, prev;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    
    HashMap<Integer, Node> map;
    int capacity;
    Node head, tail;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            int value = n.value;
            
            n.prev.next = n.next;
            n.next.prev = n.prev;
            
            map.remove(key);
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            
            return value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            map.remove(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
        } else if(map.size() == capacity){
            map.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
        
        Node newNode = new Node(key, value);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */