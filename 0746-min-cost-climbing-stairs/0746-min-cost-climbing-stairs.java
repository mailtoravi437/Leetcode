class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer dp[] = new Integer[n+2];
        return sol(n,cost,dp);
    }
    
    public int sol(int n,int cost[],Integer dp[]){
        if(n==0 || n==1){
            return 0;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int op1 = cost[n-1]+sol(n-1,cost,dp);
        int op2 = cost[n-2]+sol(n-2,cost,dp);
        
        return dp[n] = Math.min(op1,op2);
    }
}