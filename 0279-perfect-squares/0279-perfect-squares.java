class Solution {
    public int numSquares(int n) {
        Integer dp[] = new Integer[n+2];
        return sol(n,dp);
    }
    
    public int sol(int n,Integer dp[]){
        if(dp[n]!=null){
            return dp[n];
        }
        
        if(n==0){
            return 0;
        }
        
        if(n<0){
            return Integer.MAX_VALUE;
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=1;(i*i)<=n;i++){
            ans = Math.min(ans,sol(n-(i*i),dp));
        }
        
        return dp[n] = 1+ans;
    }
}