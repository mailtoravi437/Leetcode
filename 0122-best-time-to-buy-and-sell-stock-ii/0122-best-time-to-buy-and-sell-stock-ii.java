class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][] = new Integer[n][2];
        
        return sol(0,0,prices,dp);
    }
    
    public int sol(int buy,int idx,int prices[],Integer dp[][]){
        if(idx==prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        int maxProfit = 0;
        
        if(buy==0){
            int buyToday = -prices[idx]+sol(1,idx+1,prices,dp);
            int notBuy = sol(0,idx+1,prices,dp);
            maxProfit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(0,idx+1,prices,dp);
            int notSell = sol(1,idx+1,prices,dp);
            maxProfit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = maxProfit;
    }
}