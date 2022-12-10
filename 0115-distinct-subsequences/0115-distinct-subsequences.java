class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        Integer dp[][] = new Integer[n+2][m+2];
        return sol(s,0,t,0,dp);
    }
    
    public int sol(String s,int i,String t,int j,Integer dp[][]){
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        else if(j==t.length()){
            return 1;
        }
        
        else if(i==s.length() && j<t.length()){
            return 0;
        }
        
        else if(i==s.length()-1 && j==t.length()-1){
            if(s.charAt(i)==t.charAt(j)){
                return dp[i][j] = 1;
            }
            else{
                return dp[i][j] = 0;
            }
        }
        else{
            int ways = 0;
            if(s.charAt(i)==t.charAt(j)){
                ways += sol(s,i+1,t,j+1,dp);
            }
            
            ways += sol(s,i+1,t,j,dp);
            
            return dp[i][j] = ways;
        }
        
        
        
    }
}