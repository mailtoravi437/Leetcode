class Solution {
    public int minInsertions(String s) {
        String x = new StringBuilder(s).reverse().toString();
        int lps = lcs(s,s.length(),x,s.length());
        return s.length()-lps;
    }
    
    public int lcs(String s,int n,String x,int m){
        int dp[][] = new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==x.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}