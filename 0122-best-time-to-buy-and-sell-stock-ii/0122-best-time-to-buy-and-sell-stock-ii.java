class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][] = new Integer[n+2][4];
        return sol(prices,0,0,dp);
    }
    
    public int sol(int prices[],int idx,int buy,Integer dp[][]){
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        if(idx==prices.length){
            return 0;
        }
        
        int maxprofit = 0;
        
        if(buy==0){
            int buyToday = -prices[idx]+sol(prices,idx+1,1,dp);
            int notBuy = sol(prices,idx+1,0,dp);
            
            maxprofit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(prices,idx+1,0,dp);
            int notSell = sol(prices,idx+1,1,dp);
            
            maxprofit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = maxprofit;
    }
}