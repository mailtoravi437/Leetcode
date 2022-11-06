class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left_max[] = new int[n];
        int right_max[] = new int[n];
        
        left_max[0] = nums[0];
        right_max[n-1] = nums[n-1];
        
        for(int i=1;i<n;i++){
            left_max[i] = (i%k==0)?nums[i]:Math.max(left_max[i-1],nums[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            right_max[i] = (i%k==0)?nums[i]:Math.max(right_max[i+1],nums[i]);
        }
        
        int res[] = new int[n-k+1];
        for(int i=0,j=0;(i+k)<=n;i++){
            res[j++] = Math.max(right_max[i],left_max[i+k-1]);
        }
        
        return res;
    }
}