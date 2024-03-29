//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java

//using inorder traversal
/*
class Solution{
    public ArrayList <Integer> bottomView(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        inorder(root, map, 0, 0);
        PriorityQueue<Map.Entry<Integer, ArrayList<Integer>>> pq = new PriorityQueue<>(map.size(), 
                                    (a, b) -> a.getKey() - b.getKey());
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) pq.add(entry);
        
        while(pq.size() != 0) list.add(pq.poll().getValue().get(0));
        
        return list;
    }
    
    public void inorder(Node root, HashMap<Integer, ArrayList<Integer>> map, int w, int level){
        if(root == null) return;
        if(!map.containsKey(w) || (level >= map.get(w).get(1))){
            ArrayList<Integer> list = new ArrayList<>(2);
            list.add(root.data);
            list.add(level);
            map.put(w, list);
        }
    
        inorder(root.left, map, w-1, level + 1);
        inorder(root.right, map, w+1, level + 1);
    }
}
*/

//using level order traversal


class Solution{
    static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Pair> dq = new ArrayDeque<>();
        Pair p = new Pair(root, 0);
        dq.add(p);
        int level = 0;
        
        while(dq.size() != 0){
            int count = dq.size();
            for(int i = 0; i < count; i++){
                Pair temp = dq.poll();
                if(temp.node.left != null){
                    Pair left = new Pair(temp.node.left, temp.w - 1);
                    dq.add(left);
                }
                
                if(temp.node.right != null){
                    Pair right = new Pair(temp.node.right, temp.w + 1);
                    dq.add(right);
                }
                
                if(!map.containsKey(temp.w)){
                    map.put(temp.w, temp.node.data);
                } else {
                    map.replace(temp.w, temp.node.data);
                }
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : map.keySet()) pq.add(i);
        
        while(pq.size() != 0) list.add(map.get(pq.poll()));
        
        return list;
        
    }
}

class Pair{
    Node node;
    int w;
    
    public Pair(Node node, int w){
        this.node = node;
        this.w = w;
    }
}


