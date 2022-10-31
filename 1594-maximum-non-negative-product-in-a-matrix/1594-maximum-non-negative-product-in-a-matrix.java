class Solution {
    static int mod = (int)Math.pow(10,9)+7;
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        long dp[][][] = new long[n][m][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    continue;
                }
                
                long a = 0;
                long b = 0;
                
                if(i==0){
                    dp[i][j][0] = dp[i][j][1] = grid[i][j]*dp[i][j-1][0];
                }
                
                else if(j==0){
                    dp[i][j][0] = dp[i][j][1] = grid[i][j]*dp[i-1][j][0];
                }
                
                else{
                    a = grid[i][j]*Math.max(dp[i-1][j][0],dp[i][j-1][0]);
                    b = grid[i][j]*Math.min(dp[i-1][j][1],dp[i][j-1][1]);
                    
                    dp[i][j][0] = Math.max(a,b);
                    dp[i][j][1] = Math.min(a,b);
                }
            }
        }
        
        if(dp[n-1][m-1][0]<0){
            return -1;
        }
        
        return (int)((dp[n-1][m-1][0])%mod);
    }
}