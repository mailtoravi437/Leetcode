class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        
        for(int x : nums){
            totalSum += x;
        }
        
        Integer dp[][] = new Integer[n+2][n+2];
        int maxP1 =  sol(nums,0,n-1,dp);
        return maxP1>=totalSum-maxP1;
    }
    
    public int sol(int nums[],int first,int end,Integer dp[][]){
        if(first>end){
            return 0;
        }
        
        if(dp[first][end]!=null){
            return dp[first][end];
        }
        
        int selFirst = nums[first]+Math.min(sol(nums,first+2,end,dp),sol(nums,first+1,end-1,dp));
        int selLast = nums[end]+Math.min(sol(nums,first,end-2,dp),sol(nums,first+1,end-1,dp));
        
        dp[first][end] = Math.max(selFirst,selLast);
        return dp[first][end];
    }
}