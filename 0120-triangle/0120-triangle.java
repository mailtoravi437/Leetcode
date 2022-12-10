class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer dp[][] = new Integer[n+2][n+2];
        return sol(triangle,0,0,dp);
    }
    
    public int sol(List<List<Integer>> triangle,int level,int i,Integer dp[][]){
        if(dp[level][i]!=null){
            return dp[level][i];
        }
        
        int path = triangle.get(level).get(i);
        if(level<triangle.size()-1){
            path += Math.min(sol(triangle,level+1,i,dp),sol(triangle,level+1,i+1,dp));
        }
        
        return dp[level][i]=path;
    }
}