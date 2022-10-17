class Solution {
    public int longestPalindromeSubseq(String s) {
        return sol(s,0,s.length()-1,new Integer[s.length()][s.length()]);
    }
    
    public int sol(String s,int i,int j,Integer dp[][]){
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        if(i>j){
            return 0;
        }
        
        if(i==j){
            return dp[i][j] =  1;
        }
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = 2+sol(s,i+1,j-1,dp);
        }
        
        return dp[i][j] = Math.max(sol(s,i+1,j,dp),sol(s,i,j-1,dp));
    }
}