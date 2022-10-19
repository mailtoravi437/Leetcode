class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n+2][4][k+2];
        return sol(0,0,prices,k,dp);
    }
    
    public int sol(int buy,int idx,int prices[],int k,Integer dp[][][]){
        if(idx>=prices.length || k==0){
            return 0;
        }
        
        if(dp[idx][buy][k]!=null){
            return dp[idx][buy][k];
        }
        
        int maxProfit = Integer.MIN_VALUE;
        if(buy==0){
            int buyToday = -prices[idx]+sol(1,idx+1,prices,k,dp);
            int notBuy = sol(0,idx+1,prices,k,dp);
            
            maxProfit = Math.max(buyToday,notBuy);
        }
        else{
            int sellToday = prices[idx]+sol(0,idx+1,prices,k-1,dp);
            int notSell = sol(1,idx+1,prices,k,dp);
            
            maxProfit = Math.max(sellToday,notSell);
        }
        
        return dp[idx][buy][k] = maxProfit;
    }
}