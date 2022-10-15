class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n+2][4][4];
        
        return sol(0,0,2,prices,dp);
    }
    
    public int sol(int idx,int buy,int k,int prices[],Integer dp[][][]){
        if(idx>=prices.length || k==0){
            return 0;
        }
        
        
        if(dp[idx][buy][k]!=null){
            return dp[idx][buy][k];
        }
        
        int maxProfit = 0;
        
        if(buy==0){
            int buyToday = -prices[idx]+sol(idx+1,1,k,prices,dp);
            int notBuy = sol(idx+1,0,k,prices,dp);
            
            maxProfit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(idx+1,0,k-1,prices,dp);
            int notSell = sol(idx+1,1,k,prices,dp);
            
            maxProfit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy][k] = maxProfit;
    }
}