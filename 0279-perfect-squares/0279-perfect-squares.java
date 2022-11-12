class Solution {
    public int numSquares(int n) {
        Integer dp[] = new Integer[n+1];
        return helper(n,dp);
    }
    
    public int helper(int n,Integer dp[]){
        if(n<0){
            return Integer.MAX_VALUE;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        if(n==0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=1;(i*i)<=n;i++){
            min = Math.min(min,helper(n-(i*i),dp));
        }
        
        dp[n] = min+1;
        return dp[n];
    }
}