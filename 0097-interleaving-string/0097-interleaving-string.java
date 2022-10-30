class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if(m+n!=s3.length()){
            return false;
        }
        
        Boolean dp[][] = new Boolean[m+2][n+2];
        
        return sol(s1,0,s2,0,s3,0,dp);
    }
    
    public boolean sol(String s1,int i,String s2,int j,String s3,int k,Boolean dp[][]){
        if(i==s1.length()){
            return dp[i][j] = s2.substring(j).equals(s3.substring(k));
        }
        
        if(j==s2.length()){
            return dp[i][j] = s1.substring(i).equals(s3.substring(k));
        }
        
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        boolean ans = false;
        if(s1.charAt(i)==s3.charAt(k)  && sol(s1,i+1,s2,j,s3,k+1,dp) || s2.charAt(j)==s3.charAt(k) && sol(s1,i,s2,j+1,s3,k+1,dp)){
            ans = true;
        }
        
        return dp[i][j] = ans;
    }
}