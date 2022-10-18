class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curr_Max = nums[0];
        int max_till_now = nums[0];
        
        for(int i=1;i<n;i++){
            curr_Max = Math.max(curr_Max+nums[i],nums[i]);
            max_till_now = Math.max(curr_Max,max_till_now);
        }
        
        return max_till_now;
    }
}