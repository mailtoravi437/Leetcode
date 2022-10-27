class Solution {
    public int climbStairs(int n) {
        Integer dp[] = new Integer[n+2];
        return sol(dp,n);
    }
    
    public int sol(Integer dp[],int n){
        if(n<=2){
            return n;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int first = sol(dp,n-1);
        int second = sol(dp,n-2);
        
        return dp[n] = first+second;
    }
}