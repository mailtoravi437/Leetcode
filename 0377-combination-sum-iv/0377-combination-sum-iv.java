class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Integer dp[] = new Integer[target+2];
        return sol(nums,target,dp);
    }
    
    public int sol(int nums[],int target,Integer dp[]){
        if(target==0){
            return 1;
        }
        
        if(target<0){
            return 0;
        }
        
        if(dp[target]!=null){
            return dp[target];
        }
        
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(target-nums[i]>=0){
                count += sol(nums,target-nums[i],dp);
            }
        }
        
        return dp[target] = count;
    }
}