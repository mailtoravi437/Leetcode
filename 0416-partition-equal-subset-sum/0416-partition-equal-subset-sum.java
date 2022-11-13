class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        
        if(sum%2!=0){
            return false;
        }
        
        Boolean dp[][] = new Boolean[n+2][(sum/2)+2];
         
        return sol(nums,0,sum/2,dp);
    }
    
    public boolean sol(int nums[],int idx,int sum,Boolean dp[][]){
        if(sum==0){
            return true;
        }
        
        if(sum<0 || idx>=nums.length){
            return false;
        }
        
        if(dp[idx][sum]!=null){
            return dp[idx][sum];
        }
        
        
        return dp[idx][sum] =  sol(nums,idx+1,sum,dp) || sol(nums,idx+1,sum-nums[idx],dp);
        
    }
}