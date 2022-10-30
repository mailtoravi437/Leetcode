class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        Integer dp[][] = new Integer[n+2][m+2];
        
        return sol(word1,n,word2,m,dp);
    }
    
    public int sol(String word1,int n,String word2,int m,Integer dp[][]){
        if(n==0){
            return m;
        }
        
        if(m==0){
            return n;
        }
        
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return dp[n][m] = sol(word1,n-1,word2,m-1,dp);
        }
        
        int insert = sol(word1,n-1,word2,m,dp);
        int delete = sol(word1,n,word2,m-1,dp);
        int replace = sol(word1,n-1,word2,m-1,dp);
        
        
        return dp[n][m] = 1+Math.min(insert,Math.min(delete,replace));
    }
}