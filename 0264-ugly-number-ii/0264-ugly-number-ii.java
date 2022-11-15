class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        
        dp[0] = 1;
        
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        
        for(int i=1;i<n;i++){
            dp[i] = Math.min(factor2,Math.min(factor5,factor3));
            if(dp[i]==factor2){
                factor2 = 2*dp[++index2];
            }
            if(dp[i]==factor3){
                factor3 = 3*dp[++index3];
            }
            if(dp[i]==factor5){
                factor5 = 5*dp[++index5];
            }
        }
        
        return dp[n-1];
    }
}