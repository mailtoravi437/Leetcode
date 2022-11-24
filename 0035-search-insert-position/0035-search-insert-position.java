class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int idx = binarySearch(nums,0,n-1,target);
        return idx;
    }
    
    public int binarySearch(int nums[],int start,int end,int target){
        int s = start;
        int e = end;
        
        while(s<=e){
            int mid = s+((e-s)>>1);
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return s;
    }
}