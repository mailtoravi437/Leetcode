class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        
        if(sum%2!=0){
            return false;
        }
        
        sum = sum/2;
        
        Boolean dp[][] = new Boolean[nums.length+2][sum+2];
        return sol(0,sum,nums,dp);
    }
    
    public boolean sol(int idx,int target,int nums[],Boolean dp[][]){
        if(target==0){
            return true;
        }
        
        if(idx>=nums.length || target<0){
            return false;
        }
        
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        
        dp[idx][target] = sol(idx+1,target-nums[idx],nums,dp) || sol(idx+1,target,nums,dp);
        return dp[idx][target];
    }
}