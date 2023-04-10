class Solution {
    
    public void printArr(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    
    public List<Integer> pancakeSort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int maxIndex = 0;
            for(int j = 0; j < nums.length - i; j++){
                if(nums[j] > nums[maxIndex]) maxIndex = j;
            }
            
            if(maxIndex != nums.length - i - 1){
                if(maxIndex != 0){
                    for(int j = 0; j <= maxIndex/2; j++){
                        int temp = nums[j];
                        nums[j] = nums[maxIndex - j];
                        nums[maxIndex - j] = temp;
                    }
                    list.add(maxIndex + 1);
                }
                
                for(int j = 0; j <= (nums.length - i - 1)/2; j++){
                    int temp = nums[j];
                    nums[j] = nums[nums.length - i - 1 - j];
                    nums[nums.length - i - 1 - j] = temp;
                }
                
                list.add(nums.length - i);
            }
            
        }
        
        return list;
    }
    
}