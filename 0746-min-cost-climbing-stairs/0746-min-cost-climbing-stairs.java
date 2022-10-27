class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer dp[] = new Integer[n+2];
        return sol(cost,dp,n);
    }
    
    public int sol(int cost[],Integer dp[],int n){
        if(n==0 || n==1){
            return 0;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int one = sol(cost,dp,n-1)+cost[n-1];
        int second = sol(cost,dp,n-2)+cost[n-2];
        
        return dp[n] = Math.min(one,second);
    }
}