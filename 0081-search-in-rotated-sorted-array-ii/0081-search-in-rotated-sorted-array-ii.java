class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l= 0;
        int h = n-1;
        
        while(l<=h){
            int mid = l+((h-l)>>1);
            if(nums[mid]==target){
                return true;
            }
            
            if(nums[mid]==nums[h]){
                h--;
            }
            
            else if(nums[mid]<nums[h]){
                if(nums[mid]<target && target<=nums[h]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            else{
                if(nums[l]<=target && target<nums[mid]){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        
        return false;
    }
}