class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][] = new Integer[n+2][4];
        
        return sol(0,0,prices,dp);
    }
    
    public int sol(int idx,int buy,int prices[],Integer dp[][]){
        if(idx>=prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        int maxProfit = 0;
        if(buy==0){
            int buyToday = -prices[idx]+sol(idx+1,1,prices,dp);
            int notBuyToday = sol(idx+1,0,prices,dp);
            
            maxProfit = Math.max(buyToday,notBuyToday);
        }
        
        else{
            int sellToday = prices[idx]+sol(idx+2,0,prices,dp);
            int notSell = sol(idx+1,1,prices,dp);
            
            maxProfit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = maxProfit;
    }
}