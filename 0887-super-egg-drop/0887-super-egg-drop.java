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
        
        int l = 1;
        int h = n;
        int ans = Integer.MAX_VALUE;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            int down = sol(k-1,mid-1,dp);
            int up = sol(k,n-mid,dp);
            
            int temp = 1+Math.max(down,up);
            if(down>up){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
            
            ans = Math.min(ans,temp);
        }
        
        return dp[k][n] = ans;
    }
}