class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer dp[][] = new Integer[amount+2][n+2];
        return sol(amount,coins,0,dp);
    }
    
    public int sol(int amount,int coins[],int idx,Integer dp[][]){
        if(amount==0){
            return 1;
        }
        
        if(idx==coins.length || amount<0){
            return 0;
        }
        
        if(dp[amount][idx]!=null){
            return dp[amount][idx];
        }
        
        int take = 0;
        int notTake = 0;
        if(coins[idx]<=amount){
        take = sol(amount-coins[idx],coins,idx,dp);
        notTake = sol(amount,coins,idx+1,dp);
            dp[amount][idx] = take+notTake;
        }
        else{
        notTake = sol(amount,coins,idx+1,dp);
            dp[amount][idx] = notTake;
        }
        
        return dp[amount][idx];
    }
}