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
        
        Boolean dp[][] = new Boolean[nums.length+1][sum+1];
        return sol(0,nums,sum,dp);
    }
    
    public boolean sol(int idx,int nums[],int sum,Boolean dp[][]){
        if(sum==0){
            return true;
        }
        
        if(idx>=nums.length || sum<0){
            return false;
        }
        
        if(dp[idx][sum]!=null){
            return dp[idx][sum];
        }
        
        dp[idx][sum] = sol(idx+1,nums,sum-nums[idx],dp) || sol(idx+1,nums,sum,dp);
        return dp[idx][sum];
    }
}