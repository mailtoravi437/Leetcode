class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        
        Arrays.fill(dp,-1);
        
        return sol(s,dp,0);
    }
    
    public int sol(String s,int dp[],int idx){
        int n = s.length();
        if(idx==s.length()){
            return 1;
        }
        
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        if(s.charAt(idx)=='0'){
            return 0;
        }
        
        int count = sol(s,dp,idx+1);
        
        if(idx<n-1 &&  Integer.parseInt(s.substring(idx,idx+2))<27){
            count += sol(s,dp,idx+2);
        }
        
        dp[idx] = count;
        return dp[idx];
    }
}