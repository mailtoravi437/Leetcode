class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        
        int l = 0;
        int h = n-1;
        
        while(l<h){
            int mid = l+((h-l)>>2);
            
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[l]<=nums[mid] && nums[mid]>nums[h]){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        
        return nums[l];
    }
}