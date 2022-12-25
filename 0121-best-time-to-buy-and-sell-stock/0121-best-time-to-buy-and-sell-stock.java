class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int profit = 0;
        int max_profit = 0;
        int n = prices.length;
        
        for(int i=0;i<n;i++){
            if(prices[i]<min_price){
                min_price = prices[i];
            }
            else{
                max_profit = Math.max(max_profit,prices[i]-min_price);
            }
        }
        
        return max_profit;
    }
}