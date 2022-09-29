/*
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = insertIndex(arr, x, 0, arr.length - 1);
        List<Integer> list = new ArrayList<>(k);
        int backward = pos - 1;
        int forward = pos;
        
        while(list.size() != k){
            if(backward > -1 && forward < arr.length && (x - arr[backward] <= arr[forward] - x)){
                list.add(arr[backward]);
                backward--;
            } else if(backward > -1 && forward < arr.length && (x - arr[backward] > arr[forward] - x)){
                list.add(arr[forward]);
                forward++;
            } else if(backward > -1 && forward >= arr.length){
                list.add(arr[backward]);
                backward--;
            } else if(backward < 0 && forward < arr.length){
                list.add(arr[forward]);
                forward++;
            }
        }
        
        Collections.sort(list);
        return list;
    }
    
    public int insertIndex(int[] arr, int x, int start, int end){
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
}
*/


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {        
        List<Integer> list = new ArrayList<>(k);
        for(int i = 0; i < k; i++) list.add(arr[i]);
        
        for(int i = k; i < arr.length; i++){
            if(Math.abs(arr[i] - x) < Math.abs(arr[i-k] - x)){
                list.remove(0);
                list.add(arr[i]);
            } 
        }
        
        return list;
    }
    
}
