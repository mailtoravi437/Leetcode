class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        
        if(sum%2!=0){
            return false;
        }
        
        Boolean dp[][] = new Boolean[n+2][sum/2+2];
        return sol(nums,sum/2,dp,0);
    }
    
    public boolean sol(int nums[],int sum,Boolean dp[][],int idx){
        if(sum==0){
            return true;
        }
        
        if(sum<0 || idx>=nums.length){
            return false;
        }
        
        if(dp[idx][sum]!=null){
            return dp[idx][sum];
        }
        
        return dp[idx][sum] = sol(nums,sum-nums[idx],dp,idx+1) || sol(nums,sum,dp,idx+1);
    }
}