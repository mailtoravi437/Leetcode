class Solution {
    public int numTrees(int n) {
        Integer dp[] = new Integer[n+2];
        return sol(n,dp);   
    }
    
    public int sol(int n,Integer dp[]){
        if(n==0 || n==1){
            return 1;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int res = 0;
        for(int i=1;i<=n;i++){
            res += sol(i-1,dp)*sol(n-i,dp);
        }
        
        return dp[n] = res;
    }
}