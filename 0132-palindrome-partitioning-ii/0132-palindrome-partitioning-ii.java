class Solution {
    public int minCut(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n+2];
        return sol(s,0,n,dp)-1;
    }
    
    public int sol(String s,int idx,int n,Integer dp[]){
        if(idx==n){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k = idx;k<n;k++){
            if(isPalindrome(s,idx,k)){
                int next = sol(s,k+1,n,dp);
                int ans2 = 1+next;
                
                ans = Math.min(ans,ans2);
            }
        }
        
        return dp[idx]=ans;
    }
    
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}