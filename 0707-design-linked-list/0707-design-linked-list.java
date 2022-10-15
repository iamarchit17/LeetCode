class MyLinkedList {
    Node head;
    
    public MyLinkedList() {
        this.head = null;    
    }
    
    public int get(int index) {
        int x = 0;
        Node temp = head;
        while(temp != null && x < index) {
            temp = temp.next;
            x++;
        }
        
        return temp == null ? -1 : temp.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }
    
    public void addAtTail(int val) {
        if(head == null) head = new Node(val);
        else {
            Node temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = new Node(val);
        }
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            return;
        }
        int x = 0;
        Node temp = head;
        while(temp != null && x < index - 1){
            temp = temp.next;
            x++;
        }
        
        if(temp == null) return;
        else if(temp.next != null) {
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
        } else if(temp.next == null){
            temp.next = new Node(val);
        }
     }
    
    public void deleteAtIndex(int index) {
        if(index == 0 && head != null){
            head = head.next;
            return;
        }
        
        int x = 0;
        Node temp = head;
        while(temp != null && x < index - 1){
            temp = temp.next;
            x++;
        }
        
        if(temp == null || temp.next == null) return;
        else temp.next = temp.next.next; 
    }
}

class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
    
    public Node(){
        this.next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */