class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int dp[] = new int[n];
        for(int i=0;i<nums.length;i++){
            dp[nums[i]] += nums[i];
        }
        
        int skip = 0;
        int take = 0;
        
        for(int i=0;i<n;i++){
            int take_i = skip + dp[i];
            int skip_i = Math.max(skip,take);
            
            take = take_i;
            skip = skip_i;
        }
        
        return Math.max(take,skip);
    }
}