class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer dp[][] = new Integer[n][4];
        return sol(0,0,prices,dp,fee);
    }
    
    public int sol(int idx,int buy,int prices[],Integer dp[][],int fee){
        if(idx>=prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        
        int maxProfit = 0;
        if(buy==0){
            int buyToday = -prices[idx]+sol(idx+1,1,prices,dp,fee);
            int notBuy = sol(idx+1,0,prices,dp,fee);
            
            maxProfit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]-fee+sol(idx+1,0,prices,dp,fee);
            int notSell = sol(idx+1,1,prices,dp,fee);
            
            maxProfit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = maxProfit;
    }
}