class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String x = new StringBuilder(s).reverse().toString();
        
        int dp[][] = new int[n+2][n+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        
        int ans =  sol(s,n,x,n,dp);
        
        return n-ans;
    }
    
    public int sol(String s,int i,String x,int j,int dp[][]){
        if(i==0 || j==0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s.charAt(i-1)==x.charAt(j-1)){
            return dp[i][j] = 1+sol(s,i-1,x,j-1,dp);
        }
        
        return dp[i][j] = Math.max(sol(s,i-1,x,j,dp),sol(s,i,x,j-1,dp));
    }
}