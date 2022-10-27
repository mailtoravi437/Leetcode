class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n+2];
        return sol(s,dp,0);
    }
    
    public int sol(String s,Integer dp[],int idx){
        if(idx==s.length()){
            return 1;
        }
        
        if(s.charAt(idx)=='0'){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int way1 = sol(s,dp,idx+1);
        int way2 = 0;
        
        if(idx<s.length()-1 && Integer.parseInt(s.substring(idx,idx+2))<=26){
            way2 =  sol(s,dp,idx+2);
        }
        
        return dp[idx] = way1+way2;
    }
}