class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int low = 0;
        int high = nums[n-1]-nums[0];
        
        
        while(low<high){
            int mid = low+(high-low)/2;
            int left = 0;
            int count = 0;
            
            for(int right=0;right<n;right++){
                while(nums[right]-nums[left]>mid){
                    left++;
                }
                
                count += right-left;
            }
            
            if(count>=k){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        
        return low;
    }
}