class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff){
        int j = 0;
        int mad = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int index = insertIndex(list, nums[i]);
            list.add(index, nums[i]);
            
            if(list.size() >= 2){
                if(index == 0) mad = Math.min(mad, list.get(1) - list.get(0));
                else if(index == list.size() - 1) mad = Math.min(mad, list.get(index) - list.get(index - 1));
                else{
                    mad = Math.min(mad, list.get(index + 1) - list.get(index));
                    mad = Math.min(mad, list.get(index) - list.get(index - 1));
                }
                
                if(mad <= valueDiff) return true;
            }
            
            if(list.size() == indexDiff + 1){
                list.remove(findIndex(list, nums[j]));
                j++;
            }
        }
        
        return false;
    }
    
    public int insertIndex(List<Integer> list, int ele){
        int s = 0;
        int e = list.size() - 1;
        
        while(s <= e){
            int mid = s + (e - s)/2;
            if(list.get(mid) == ele) return mid;
            else if(list.get(mid) < ele) s = mid + 1;
            else e = mid - 1;
        }
        
        return e + 1;
    }
    
    public int findIndex(List<Integer> list, int ele){
        int s = 0;
        int e = list.size() -1;
        
        while(s <= e){
            int mid = s + (e - s)/2;
            if(list.get(mid) == ele) return mid;
            else if(list.get(mid) < ele) s = mid + 1;
            else e = mid - 1;
        }
        
        return -1;
    }
}