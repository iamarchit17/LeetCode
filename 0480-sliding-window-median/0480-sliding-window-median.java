class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(k);
        int j = 0;
        double[] res = new double[nums.length - k + 1];
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(list.size() == 0) list.add(nums[i]);
            else list.add(insertIndex(list, nums[i]), nums[i]);
            if(i - j + 1 == k){
                if(k % 2 == 1){
                    res[index] = 1.0 * list.get(k/2);
                } else {
                    double x = 1.0 * list.get(k/2);
                    x += list.get(k/2-1);
                    res[index] = x/2.0; 
                }

                index++;
                list.remove(findIndex(list, nums[j]));
                j++;
            }
        }

        return res;
    }

    public int insertIndex(List<Integer> list, int element){
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(list.get(mid) == element) return mid;
            else if(list.get(mid) < element) start = mid + 1;
            else end = mid - 1;
        }

        return end + 1;
    }

    public int findIndex(List<Integer> list, int element){
        int start = 0;
        int end = list.size() - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(list.get(mid) == element) return mid;
            else if(list.get(mid) < element) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}