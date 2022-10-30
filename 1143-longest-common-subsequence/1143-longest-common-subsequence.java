class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        Integer dp[][] = new Integer[n+2][m+2];
        
        return sol(text1,n,text2,m,dp);
    }
    
    public int sol(String text1,int n,String text2,int m,Integer dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return dp[n][m] = 1+sol(text1,n-1,text2,m-1,dp);
        }
        
        return dp[n][m] = Math.max(sol(text1,n-1,text2,m,dp),sol(text1,n,text2,m-1,dp));
    }
}