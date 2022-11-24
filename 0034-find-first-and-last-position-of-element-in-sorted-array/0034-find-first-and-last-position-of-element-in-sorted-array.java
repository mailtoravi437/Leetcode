class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = sol(nums,target,false);
        int end = sol(nums,target,true);
        
        return new int[]{start,end};
    }
    
    public int sol(int nums[],int target,boolean isLast){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int index = -1;
        
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(isLast){
                if(nums[mid]<=target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{
                if(nums[mid]<target){
                    low= mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            
            if(nums[mid]==target){
                index = mid;
            }
        }
        
        return index;
    }
}