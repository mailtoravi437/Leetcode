class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_price = Integer.MAX_VALUE;
        int max_profit = Integer.MIN_VALUE;
        int profit = 0;
        for(int i=0;i<n;i++){
            if(min_price>prices[i]){
                min_price = prices[i];
            }
            else{
                profit = prices[i]-min_price;
            }
            max_profit = Math.max(max_profit,profit);
        }
        
        return max_profit;
    }
}