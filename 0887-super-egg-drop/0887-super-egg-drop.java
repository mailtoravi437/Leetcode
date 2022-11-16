class Solution {
    public int superEggDrop(int k, int n) {
        Integer dp[][] = new Integer[k+2][n+2];
        return sol(k,n,dp);
    }
    
    public int sol(int k,int n,Integer dp[][]){
        if(n<=1){
            return n;
        }
        
        if(k==1){
            return n;
        }
        
        
        if(dp[k][n]!=null){
            return dp[k][n];
        }
        
        int ans = Integer.MAX_VALUE;
        int  l = 1;
        int h = n;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            int up = sol(k,n-mid,dp);
            int down = sol(k-1,mid-1,dp);
            
            int temp = 1+ Math.max(up,down);
            if(up>down){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
            
            ans = Math.min(ans,temp);
        }
        
        return dp[k][n]=ans;
        
    }
}