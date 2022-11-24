class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int n = nums.length;
        int l = 0;
        int h = n-1;
        
        while(l<h){
            int mid = l+((h-l)>>1);
            if(mid>0 && nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            
            if(nums[l]<=nums[mid] && nums[mid]>nums[h]){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return nums[l];
    }
}