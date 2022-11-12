class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][] = new Integer[n+2][4];
        return sol(prices,0,0,dp);
    }
    
    public int sol(int prices[],int buy,int idx,Integer dp[][]){
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        if(idx==prices.length){
            return 0;
        }
        
        int max = 0;
        if(buy==0){
            int buytoday = -prices[idx]+sol(prices,1,idx+1,dp);
            int notBuy = sol(prices,0,idx+1,dp);
            
            max = Math.max(buytoday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(prices,0,idx+1,dp);
            int notSell = sol(prices,1,idx+1,dp);
            
            max = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = max;
    }
}