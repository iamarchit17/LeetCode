//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList <Integer> verticalOrder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map = new HashMap<>();
        preorder(root, map, 0, 0);
        
        PriorityQueue<Map.Entry<Integer, HashMap<Integer, ArrayList<Integer>>>> pq = new
                                PriorityQueue<>(10000, (l1, l2) -> l1.getKey() - l2.getKey());
        
        for(Map.Entry<Integer, HashMap<Integer, ArrayList<Integer>>> e : map.entrySet()) pq.add(e); 
        
        while(pq.size() != 0){
            Map.Entry<Integer, HashMap<Integer, ArrayList<Integer>>> entry = pq.poll();
            PriorityQueue<Map.Entry<Integer, ArrayList<Integer>>> pq1 = new PriorityQueue<>(10000,
                                        (l1, l2) -> l1.getKey() - l2.getKey());
            
            for(Map.Entry<Integer, ArrayList<Integer>> e : entry.getValue().entrySet()) pq1.add(e);
            
            while(pq1.size() != 0){
                ArrayList<Integer> l = pq1.poll().getValue();
                for(int i = 0; i < l.size(); i++) list.add(l.get(i));
            }
        }    
        
        return list;
    }
    
    static void preorder(Node root, HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map, int w, int level){
        if(root == null) return;
        if(!map.containsKey(w)){
            HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            m.put(level, list);
            map.put(w, m);
        } else{
            if(map.get(w).containsKey(level)){
                map.get(w).get(level).add(root.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.data);
                map.get(w).put(level, list);
            }
        }
        
        preorder(root.left, map, w - 1, level + 1);
        preorder(root.right, map, w + 1, level + 1);
        
    }
}