class Solution {
    private int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public double knightProbability(int n, int k, int row, int column) {
        Double dp[][][] = new Double[n+2][n+2][k+2];
        return sol(n,k,row,column,dp);
    }
    
    public double sol(int N,int K,int row,int col,Double dp[][][]){
       if(row<0 || col<0 || row>=N || col>=N){
           return 0.0;
       }
        
        if(K==0){
            return 1;
        }
        
        if(dp[row][col][K]!=null){
            return dp[row][col][K];
        }
        double res = 0.0;
        for(int i=0;i<8;i++){
            res += 0.125*sol(N,K-1,row+dir[i][0],col+dir[i][1],dp);
        }
        
        return dp[row][col][K] = res;
    }
}