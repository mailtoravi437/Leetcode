class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int dp[] = new int[10001];
        for(int x : nums){
            dp[x] += x;
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
        
        int include = arr[idx] + sol(arr,idx+2,dp);
        int exclude = sol(arr,idx+1,dp);
        
        return dp[idx] = Math.max(include,exclude);
    }
}