class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_Price = Integer.MAX_VALUE;
        int max_Profit = Integer.MIN_VALUE;
        int profit = 0;
        
        for(int i=0;i<n;i++){
            if(prices[i]<min_Price){
                min_Price = prices[i];
            }
            else{
                profit = prices[i]-min_Price;
            }
            
            max_Profit = Math.max(max_Profit,profit);
        }
        
        return max_Profit;
    }
}