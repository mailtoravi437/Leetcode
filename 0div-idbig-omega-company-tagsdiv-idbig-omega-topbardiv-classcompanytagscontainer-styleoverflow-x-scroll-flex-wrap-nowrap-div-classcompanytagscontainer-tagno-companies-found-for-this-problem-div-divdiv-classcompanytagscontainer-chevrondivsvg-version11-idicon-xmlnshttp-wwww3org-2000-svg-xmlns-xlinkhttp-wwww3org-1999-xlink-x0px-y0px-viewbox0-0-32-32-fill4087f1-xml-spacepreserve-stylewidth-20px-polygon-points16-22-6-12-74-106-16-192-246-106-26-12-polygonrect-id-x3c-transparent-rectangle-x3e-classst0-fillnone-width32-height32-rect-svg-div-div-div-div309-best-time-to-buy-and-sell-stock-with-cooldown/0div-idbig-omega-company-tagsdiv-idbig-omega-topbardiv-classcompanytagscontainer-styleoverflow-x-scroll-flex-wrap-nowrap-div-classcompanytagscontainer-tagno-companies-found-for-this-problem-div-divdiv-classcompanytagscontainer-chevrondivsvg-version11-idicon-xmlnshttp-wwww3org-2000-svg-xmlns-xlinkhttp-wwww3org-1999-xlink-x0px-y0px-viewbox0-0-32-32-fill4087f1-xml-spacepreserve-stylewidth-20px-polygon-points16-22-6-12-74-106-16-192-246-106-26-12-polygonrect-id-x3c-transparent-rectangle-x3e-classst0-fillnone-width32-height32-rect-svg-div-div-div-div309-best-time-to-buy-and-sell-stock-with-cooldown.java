class Solution {
    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length+2][4];
        return sol(prices,dp,0,0);
    }
    
    public int sol(int prices[],Integer dp[][],int idx,int buy){
        int profit = 0;
        
        if(idx>=prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        if(buy==0){
            int buyToday = -prices[idx]+sol(prices,dp,idx+1,1);
            int notBuy = sol(prices,dp,idx+1,0);
            
            profit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(prices,dp,idx+2,0);
            int notSell = sol(prices,dp,idx+1,1);
            
            profit = Math.max(sellToday,notSell);
        }
        
        dp[idx][buy] = profit;
        return profit;
    }
}