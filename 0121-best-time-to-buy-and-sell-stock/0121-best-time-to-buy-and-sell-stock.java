class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;
        
        for(int i=0;i<n;i++){
            if(prices[i]<min_price){
                min_price = prices[i];
            }
            else{
                maxProfit = Math.max(maxProfit,prices[i]-min_price);
            }
        }
        
        return maxProfit;
    }
}