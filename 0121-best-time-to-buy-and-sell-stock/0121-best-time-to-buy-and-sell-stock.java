class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int ans = 0;
        int profit = 0;
        int min_price = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<min_price){
                min_price = prices[i];
            }
            else{
                profit = prices[i]-min_price;
            }
            
            ans = Math.max(ans,profit);
        }
        
        return ans;
    }
}