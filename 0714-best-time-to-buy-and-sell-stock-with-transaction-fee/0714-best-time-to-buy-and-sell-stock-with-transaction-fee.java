class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer dp[][] = new Integer[n+2][3];
        return sol(prices,fee,0,0,dp);
    }
    
    public int sol(int prices[],int fee,int buy,int idx,Integer dp[][]){
        if(idx>=prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        int res = 0;
        if(buy==0){
            int buyToday = -prices[idx]+sol(prices,fee,1,idx+1,dp);
            int notBuy = sol(prices,fee,0,idx+1,dp);
            
            res = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]-fee+sol(prices,fee,0,idx+1,dp);
            int notSell = sol(prices,fee,1,idx+1,dp);
            
            res = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = res;
    }
}