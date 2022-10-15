class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        Integer dp[][][] = new Integer[n+2][4][k+2];
        return sol(0,0,prices,k,dp);
     }
    
    public int sol(int idx,int buy,int prices[],int k,Integer dp[][][]){
        if(idx>=prices.length || k==0){
            return 0;
        }
        
        if(dp[idx][buy][k]!=null){
            return dp[idx][buy][k];
        }
        
        int maxProfit = 0;
        
        if(buy==0){
            int buyToday = -prices[idx]+sol(idx+1,1,prices,k,dp);
            int notBuy = sol(idx+1,0,prices,k,dp);
            
            maxProfit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(idx+1,0,prices,k-1,dp);
            int notSell = sol(idx+1,1,prices,k,dp);
            
            maxProfit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy][k] = maxProfit;
    }
}