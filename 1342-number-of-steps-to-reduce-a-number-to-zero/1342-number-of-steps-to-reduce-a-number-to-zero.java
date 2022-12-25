class Solution {
    public int numberOfSteps(int num) {
        Integer dp[] = new Integer[num+2];
        return sol(num,dp);
    }
    
    public int sol(int n,Integer dp[]){
        if(n==0){
            return 0;
        }
        
        if(dp[n]!=null){
            return dp[n];
        }
        
        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        
        if(n%2==0){
            op1 = sol(n/2,dp)+1;
        }
        else{
            op2 = sol(n-1,dp)+1;
        }
        
        return dp[n] = Math.min(op1,op2);
    }
}