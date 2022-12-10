class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n+2][4][4];
        return sol(prices,0,0,2,dp);
    }
    
    public int sol(int prices[],int idx,int buy,int k,Integer dp[][][]){
        if(dp[idx][buy][k]!=null){
            return dp[idx][buy][k];
        }
        
        if(idx>=prices.length || k==0){
            return 0;
        }
        
        int maxprofit = 0;
        if(buy==0){
            int buyToday = -prices[idx]+sol(prices,idx+1,1,k,dp);
            int notBuy = sol(prices,idx+1,0,k,dp);
            maxprofit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(prices,idx+1,0,k-1,dp);
            int notSell = sol(prices,idx+1,1,k,dp);
            maxprofit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy][k] = maxprofit;
    }
}