class Solution {
    public int climbStairs(int n) {
        Integer dp[] = new Integer[n+2];
        return sol(n,dp);
    }
    
    public int sol(int n,Integer dp[]){
        if(n<=2){
            return n;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int lh = sol(n-1,dp);
        int rh = sol(n-2,dp);
        
        return dp[n] = lh+rh;
    }
}