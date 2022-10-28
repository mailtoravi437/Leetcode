class Solution {
    static int mod = (int)Math.pow(10,9)+7;
    public int knightDialer(int n) {
        Long dp[][][] = new Long[n+2][4][3];
        long s = 0;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                s = (s+path(i,j,dp,n))%mod;
            }
        }
        
        return (int)s;
    }
    
    public long path(int i,int j,Long dp[][][],int n){
        if(i<0 || i>=4 || j<0 || j>=3 || (i==3 && j!=1)){
            return 0;
        }
        
        if(n==1){
            return 1;
        }
        
        if(dp[n][i][j]!=null){
            return dp[n][i][j];
        }
        
        dp[n][i][j] = path(i-1,j-2,dp,n-1)%mod+
                      path(i-2,j-1,dp,n-1)%mod+
                    path(i-2,j+1,dp,n-1)%mod+
                    path(i-1,j+2,dp,n-1)%mod+
                    path(i+1,j+2,dp,n-1)%mod+
                    path(i+2,j+1,dp,n-1)%mod+
                    path(i+2,j-1,dp,n-1)%mod+
                    path(i+1,j-2,dp,n-1)%mod;
        
        return dp[n][i][j];
    }
}