class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        Integer dp[][] = new Integer[m+2][n+2];
        
        return sol(word1,m,word2,n,dp);
    }
    
    public int sol(String word1,int m,String word2,int n,Integer dp[][]){
        if(m==0 && n==0){
            return 0;
        }
        
        if(dp[m][n]!=null){
            return dp[m][n];
        }
        
        if(m==0){
            return n;
        }
        
        if(n==0){
            return m;
        }
        
        if(word1.charAt(m-1)==word2.charAt(n-1)){
            return dp[m][n] = sol(word1,m-1,word2,n-1,dp);
        }
        
        else{
            int insert = sol(word1,m,word2,n-1,dp);
            int delete = sol(word1,m-1,word2,n,dp);
            
            int replace = sol(word1,m-1,word2,n-1,dp);
            
            return dp[m][n] = 1+Math.min(insert,Math.min(delete,replace));
        }
    }
}