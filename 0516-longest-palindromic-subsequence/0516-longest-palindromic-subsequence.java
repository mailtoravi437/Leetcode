class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer dp[][] = new Integer[s.length()+2][s.length()+2];
        return sol(0,s.length()-1,s,dp);
    }
    
    public int sol(int i,int j,String s,Integer dp[][]){
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        if(i>j){
            return 0;
        }
        
        if(i==j){
            return dp[i][j] = 1;
        }
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = 2+sol(i+1,j-1,s,dp);
        }
        
        return dp[i][j] = Math.max(sol(i+1,j,s,dp),sol(i,j-1,s,dp));
    }
}