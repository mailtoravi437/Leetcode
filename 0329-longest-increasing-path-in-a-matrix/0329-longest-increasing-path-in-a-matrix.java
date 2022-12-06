class Solution {
    public static final int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Integer dp[][] = new Integer[m][n];
        
        int ans = 1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len = dfs(matrix,i,j,m,n,dp);
                ans = Math.max(ans,len);
            }
        }
        
        return ans;
    }
    
    public int dfs(int matrix[][],int i,int j,int m,int n,Integer dp[][]){
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        int max = 1;
        for(int di[] : dir){
            int x = i+di[0];
            int y = j+di[1];
            
            if(x<0 || y<0 || x>=m || y>=n || matrix[x][y]<=matrix[i][j]){
                continue;
            }
            
            int len = 1+dfs(matrix,x,y,m,n,dp);
            max = Math.max(max,len);
        }
        
        return dp[i][j] = max;
    }
}