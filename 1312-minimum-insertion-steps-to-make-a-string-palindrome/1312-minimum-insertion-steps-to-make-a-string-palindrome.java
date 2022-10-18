class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        String x = new StringBuilder(s).reverse().toString();
                int dp[][] = new int[n+2][n+2];

        for(int i=0;i<=n+1;i++){
            for(int j=0;j<=n+1;j++){
                dp[i][j] = -1;
            }
        }
        return n-lcs(s,n,x,n,dp);
    }
    
    public int lcs(String s,int n,String x,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        
        if(s.charAt(n-1)==x.charAt(m-1)){
            return dp[n][m] = 1+lcs(s,n-1,x,m-1,dp);
        }
        
        return dp[n][m] = Math.max(lcs(s,n-1,x,m,dp),lcs(s,n,x,m-1,dp));
    }
}