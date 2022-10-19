class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer dp[][] = new Integer[n+2][4];
        return sol(0,0,prices,fee,dp);
    }
    
    public int sol(int buy,int idx,int prices[],int fee,Integer dp[][]){
        if(idx>=prices.length){
            return 0;
        }
        
        if(dp[idx][buy]!=null){
            return dp[idx][buy];
        }
        
        int maxValue = Integer.MIN_VALUE;
        if(buy==0){
            int buyToday = -prices[idx]+sol(1,idx+1,prices,fee,dp);
            int notBuy = sol(0,idx+1,prices,fee,dp);
            
            maxValue = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]-fee+sol(0,idx+1,prices,fee,dp);
            int notSell = sol(1,idx+1,prices,fee,dp);
            
            maxValue = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy] = maxValue;
    }
}