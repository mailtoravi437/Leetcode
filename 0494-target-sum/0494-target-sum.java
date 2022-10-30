class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        Integer dp[][] = new Integer[nums.length+2][target+2001];
        return sol(nums,target,0,0,count,dp);
    }
    
    public int sol(int nums[],int target,int idx,int sum,int count,Integer dp[][]){
        if(idx==nums.length){
            if(sum==target){
                count++;
            }
            
            return count;
        }
        
        if(dp[idx][sum+1000]!=null){
            return dp[idx][sum+1000];
        }
        
        int pos = sol(nums,target,idx+1,sum+nums[idx],count,dp);
        int neg = sol(nums,target,idx+1,sum-nums[idx],count,dp);
        
        
        return dp[idx][sum+1000] = pos+neg;
    }
}