class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans[] = new int[m];
        
        for(int j=0;j<m;j++){
            int currPos = j;
            int nextPos = -1;
            
            for(int i=0;i<n;i++){
                nextPos = grid[i][currPos]+currPos;
                
                if(nextPos<0 || nextPos>=m || grid[i][currPos]!=grid[i][nextPos]){
                    currPos = -1;
                    break;
                }
                
                currPos = nextPos;
            }
            
            ans[j] = currPos;
        }
        
        return ans;
    }
}