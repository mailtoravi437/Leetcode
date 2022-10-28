class Solution {
    public int deleteAndEarn(int[] nums) {
        int dp[] = new int[10001];
        for(int num : nums){
            dp[num] += num;
        }
        
        Integer res[] = new Integer[dp.length];
        return sol(dp,0,res);
    }
    
    public int sol(int arr[],int idx,Integer dp[]){
        if(idx>=dp.length){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int include = sol(arr,idx+2,dp) + arr[idx];
        int exclude = sol(arr,idx+1,dp);
        
        return dp[idx] = Math.max(include,exclude);
    }
}