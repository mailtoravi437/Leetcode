class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return Math.min(sol(cost,dp,n-1),sol(cost,dp,n-2));
    }
    
    public int sol(int cost[],int dp[],int n){
        if(n==0 || n==1){
            return cost[n];
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        dp[n] = cost[n]+Math.min(sol(cost,dp,n-1),sol(cost,dp,n-2));
        return dp[n];
    }
}