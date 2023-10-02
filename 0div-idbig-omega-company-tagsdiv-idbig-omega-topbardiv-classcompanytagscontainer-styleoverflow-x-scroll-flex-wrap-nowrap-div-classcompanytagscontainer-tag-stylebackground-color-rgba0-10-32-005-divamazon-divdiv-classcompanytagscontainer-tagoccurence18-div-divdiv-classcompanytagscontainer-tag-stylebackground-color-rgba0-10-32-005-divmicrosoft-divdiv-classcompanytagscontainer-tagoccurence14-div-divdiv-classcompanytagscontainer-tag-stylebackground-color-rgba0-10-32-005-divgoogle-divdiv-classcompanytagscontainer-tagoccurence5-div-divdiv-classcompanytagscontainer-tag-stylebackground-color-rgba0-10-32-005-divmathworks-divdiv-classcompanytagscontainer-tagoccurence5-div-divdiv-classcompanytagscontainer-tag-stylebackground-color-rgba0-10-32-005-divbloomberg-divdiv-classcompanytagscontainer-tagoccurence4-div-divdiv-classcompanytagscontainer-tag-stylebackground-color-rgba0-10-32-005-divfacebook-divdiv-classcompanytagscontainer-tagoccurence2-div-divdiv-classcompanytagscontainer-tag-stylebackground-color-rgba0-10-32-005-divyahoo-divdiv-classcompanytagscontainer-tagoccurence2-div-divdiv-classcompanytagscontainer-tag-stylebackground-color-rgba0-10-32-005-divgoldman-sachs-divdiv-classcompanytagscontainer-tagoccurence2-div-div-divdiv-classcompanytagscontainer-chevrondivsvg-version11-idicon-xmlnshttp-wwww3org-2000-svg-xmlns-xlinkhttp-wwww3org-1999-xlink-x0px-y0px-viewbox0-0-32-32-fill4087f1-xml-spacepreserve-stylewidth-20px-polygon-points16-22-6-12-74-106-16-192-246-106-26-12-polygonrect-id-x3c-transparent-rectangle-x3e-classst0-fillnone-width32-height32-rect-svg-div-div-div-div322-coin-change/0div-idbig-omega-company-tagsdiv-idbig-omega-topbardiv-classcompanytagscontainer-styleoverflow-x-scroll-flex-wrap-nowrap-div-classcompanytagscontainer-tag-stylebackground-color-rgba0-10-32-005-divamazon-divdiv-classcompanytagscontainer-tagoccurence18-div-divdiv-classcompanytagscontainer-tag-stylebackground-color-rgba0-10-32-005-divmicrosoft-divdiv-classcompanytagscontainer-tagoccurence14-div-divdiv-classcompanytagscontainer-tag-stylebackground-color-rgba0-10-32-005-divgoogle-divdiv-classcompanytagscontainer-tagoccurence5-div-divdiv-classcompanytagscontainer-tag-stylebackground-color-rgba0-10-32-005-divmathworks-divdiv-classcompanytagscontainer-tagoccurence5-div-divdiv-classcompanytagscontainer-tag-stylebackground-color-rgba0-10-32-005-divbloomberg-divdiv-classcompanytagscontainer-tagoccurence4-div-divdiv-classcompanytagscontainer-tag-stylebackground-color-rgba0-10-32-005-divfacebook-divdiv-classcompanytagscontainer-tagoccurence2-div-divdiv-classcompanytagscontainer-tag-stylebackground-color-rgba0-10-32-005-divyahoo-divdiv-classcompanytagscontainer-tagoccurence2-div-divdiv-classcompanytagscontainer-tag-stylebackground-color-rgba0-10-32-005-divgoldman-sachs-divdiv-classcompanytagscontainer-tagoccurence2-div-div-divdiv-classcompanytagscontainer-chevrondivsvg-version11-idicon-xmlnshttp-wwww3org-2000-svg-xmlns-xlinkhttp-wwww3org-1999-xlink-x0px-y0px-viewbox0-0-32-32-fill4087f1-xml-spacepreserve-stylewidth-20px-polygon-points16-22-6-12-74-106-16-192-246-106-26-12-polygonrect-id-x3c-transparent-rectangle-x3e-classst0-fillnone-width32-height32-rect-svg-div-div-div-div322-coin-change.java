class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        
        if(amount<1){
            return 0;
        }
        
        solve(coins,dp,amount);
        return dp[amount];
    }
    
    public int solve(int coins[],int dp[],int amount){
        if(amount<0){
            return -1;
        }
        
        if(amount==0){
            return 0;
        }
        if(dp[amount]!=0){
            return dp[amount];
        }
        
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = solve(coins,dp,amount-coin);
            if(res>=0 && res<min){
                min = res+1;
            }
        }
        dp[amount] = min==Integer.MAX_VALUE?-1:min;
        return dp[amount];
        
    }
}