class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-1;
        
        while(high-low>=k){
            if(Math.abs(x-arr[low])>Math.abs(x-arr[high])){
                low++;
            }
            else{
                high--;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(low<=high){
            res.add(arr[low]);
            low++;
        }
        return res;
    }
}