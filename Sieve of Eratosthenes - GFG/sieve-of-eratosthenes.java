//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] marked = new boolean[N+1];
        marked[0] = marked[1] = true;
        
        
        
        for(int i = 2; i <= N; i++){
            if(!marked[i]){
                list.add(i);
                for(int x = i*i; x <= N; x += i){
                    marked[x] = true;
                }
            }
        }
        

        return list;
    }
}