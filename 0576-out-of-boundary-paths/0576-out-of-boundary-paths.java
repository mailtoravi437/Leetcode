class Solution {
    static int mod = (int)((1e9)+7);
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer memo[][][] = new Integer[m+2][n+2][maxMove+2];
        return sol(m,n,maxMove,startRow,startColumn,memo);
    }
    
    public int sol(int m,int n,int maxMove,int startRow,int startColumn,Integer dp[][][]){
        if(m==startRow || n==startColumn || startRow<0 || startColumn<0){
            return 1;
        }
        
        if(maxMove==0){
            return 0;
        }
        
        if(dp[startRow][startColumn][maxMove]!=null){
            return dp[startRow][startColumn][maxMove];
        }
        
        int up = sol(m,n,maxMove-1,startRow+1,startColumn,dp);
        int down = sol(m,n,maxMove-1,startRow-1,startColumn,dp);
        int right = sol(m,n,maxMove-1,startRow,startColumn+1,dp);
        int left = sol(m,n,maxMove-1,startRow,startColumn-1,dp);
        
        return dp[startRow][startColumn][maxMove] = ((up+down)%mod+(left+right)%mod)%mod;
    }
}