class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        
        while((high-low)>=k){
            if(Math.abs(arr[low]-x)>Math.abs(arr[high]-x)){
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