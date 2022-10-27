class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        
        if(n==1){
            return nums[0];
        }
        else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            int include = 0;
            int exclude = 0;
            
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for(int i=2;i<n;i++){
                include = dp[i-2]+nums[i];
                exclude = dp[i-1];
                
                dp[i] = Math.max(include,exclude);
            }
        }
        
        return dp[n-1];
    }
}