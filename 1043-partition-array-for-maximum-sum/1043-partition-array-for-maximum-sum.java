class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer dp[] = new Integer[n+2];
        return sol(arr,k,0,dp,n);
    }
    
    public int sol(int arr[],int k,int idx,Integer dp[],int n){
        if(idx>=n){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        
        int len = 0;
        for(int k1=idx;k1<Math.min(idx+k,n);k1++){
            max = Math.max(max,arr[k1]);
            len++;
            int nextCall = sol(arr,k,k1+1,dp,n);
            ans = Math.max(ans,nextCall+len*max);
        }
        
        return dp[idx] = ans;
    }
}