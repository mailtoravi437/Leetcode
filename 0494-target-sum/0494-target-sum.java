class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        Integer dp[][] = new Integer[n+2][target+2001];
        return sol(nums,0,0,count,target,dp);
    }
    
    public int sol(int nums[],int idx,int sum,int count,int target,Integer dp[][]){
        if(idx==nums.length){
            if(sum==target){
                count++;
            }
            
            return count;
        }
        
        
        if(dp[idx][sum+1000]!=null){
            return dp[idx][sum+1000];
        }
        
        int pos = sol(nums,idx+1,sum+nums[idx],count,target,dp);
        int neg = sol(nums,idx+1,sum-nums[idx],count,target,dp);
        
        return dp[idx][sum+1000] = pos+neg;
        
    }
}