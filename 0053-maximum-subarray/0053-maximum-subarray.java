class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curr_Max = 0;
        int max_till_now = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            curr_Max = Math.max(curr_Max+nums[i],nums[i]);
            max_till_now = Math.max(curr_Max,max_till_now);
        }
        
        return max_till_now;
    }
}