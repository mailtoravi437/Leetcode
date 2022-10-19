class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<n;i++){
            int in = dp[i-2] + nums[i];
            int ex = dp[i-1];
            
            
            dp[i] = Math.max(in,ex);
        }
        
        return dp[n-1];
    }
}