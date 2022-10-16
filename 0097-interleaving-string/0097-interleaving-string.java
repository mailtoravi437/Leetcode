class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if(m+n!=s3.length()){
            return false;
        }
        Boolean dp[][] = new Boolean[s1.length()+2][s2.length()+2];
        return sol(0,s1,0,s2,0,s3,dp);
    }
    
    public boolean sol(int i,String s1,int j,String s2,int k,String s3,Boolean dp[][]){
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
        
        if(s1.charAt(i)==s3.charAt(k) && sol(i+1,s1,j,s2,k+1,s3,dp) || s2.charAt(j)==s3.charAt(k) && sol(i,s1,j+1,s2,k+1,s3,dp)){
            ans = true;
        }
        
        return dp[i][j] = ans;
    }
}