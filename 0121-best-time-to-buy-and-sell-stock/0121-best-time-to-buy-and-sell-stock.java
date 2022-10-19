class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_price = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(min_price>prices[i]){
                min_price = prices[i];
            }
            else{
                profit = prices[i]-min_price;
            }
            
            maxProfit = Math.max(profit,maxProfit);
        }
        
        return maxProfit;
    }
}