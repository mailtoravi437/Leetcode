class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int oneRow[] = new int[n];
        int oneCol[] = new int[m];
        
        int zeroRow[] = new int[n];
        int zeroCol[] = new int[m];
        
        int diff[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    zeroRow[i] += 1;
                    zeroCol[j] += 1;
                }
                else{
                    oneRow[i] += 1;
                    oneCol[j] += 1;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]  = oneRow[i]+oneCol[j] - zeroRow[i]-zeroCol[j];
            }
        }
        
        return diff;
    }
}