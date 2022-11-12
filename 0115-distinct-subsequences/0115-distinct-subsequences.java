class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        Integer dp[][] = new Integer[n+2][m+2];
        
        return sol(s,0,t,0,dp);
    }
    
    public int sol(String s,int n,String t,int m,Integer dp[][]){
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        
        if(m==t.length()){
            return 1;
        }
        
        else if(n==s.length() && m<t.length()){
            return 0;
        }
        else if(n==s.length()-1 && m==t.length()-1){
            if(s.charAt(n)==t.charAt(m)){
                dp[n][m] = 1;
            }
            else{
                dp[n][m] =  0;
            }
        }
        
        else{
            int ways = 0;
            if(s.charAt(n)==t.charAt(m)){
                ways += sol(s,n+1,t,m+1,dp);
            }
            
            ways += sol(s,n+1,t,m,dp);
            dp[n][m] = ways;
        }
        
        return dp[n][m];
        
    }
}