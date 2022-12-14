class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n+2];
        return sol(s,0,dp);
    }
    
    public int sol(String s,int idx,Integer dp[]){
        if(idx==s.length()){
            return 1;
        }
        
        if(s.charAt(idx)=='0'){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int ways1 = sol(s,idx+1,dp);
        int ways2 = 0;
        
        if(idx<s.length()-1 && Integer.parseInt(s.substring(idx,idx+2))<=26){
            ways2 = sol(s,idx+2,dp);
        }
        
        return dp[idx] = ways1+ways2;
    }
}