// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         List<Integer> list = new ArrayList<>();
//         int[] res = new int[nums.length - k + 1];
//         int x = 0;
//         int j = 0;

//         for(int i = 0; i < nums.length; i++){

//             while(list.size() != 0 && list.get(list.size() - 1) < nums[i]) list.remove(list.size() - 1);
//             list.add(nums[i]);
//             //System.out.println(list);

//             if(i - j + 1 == k){
//                 res[x++] = list.get(0);

//                 if(nums[j] == list.get(0)) list.remove(0);
//                 j++; 
//             }
//         }
        
//         return res;
//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int x = 0;
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            while(dq.size() != 0 && dq.peekLast() < nums[i]) dq.removeLast();
            dq.add(nums[i]);

            if(i - j + 1 == k){
                res[x++] = dq.peekFirst();
                if(nums[j] == dq.peekFirst()) dq.removeFirst();
                j++; 
            }
        }
        
        return res;
    }
}