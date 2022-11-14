class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer dp[] = new Integer[n+2];
        return sol(cost,dp,n);
    }
    
    public int sol(int costs[],Integer dp[],int n){
        if(n==0 || n==1){
            return 0;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int one = costs[n-1]+sol(costs,dp,n-1);
        int two = costs[n-2]+sol(costs,dp,n-2);
        
        return dp[n] = Math.min(one,two);
    }
}