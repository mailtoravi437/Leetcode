class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        Integer dp[][] = new Integer[nums.length+2][2001];
        return sol(0,0,target,nums,count,dp);
    }
    
    public int sol(int idx,int sum,int target,int nums[],int count,Integer dp[][]){
        if(idx==nums.length){
            if(sum==target){
                count++;
            }
            
            return count;
        }
        
        if(dp[idx][sum+1001]!=null){
            return dp[idx][sum+1001];
        }
        
        int pos = sol(idx+1,sum+nums[idx],target,nums,count,dp);
        int neg = sol(idx+1,sum-nums[idx],target,nums,count,dp);
        
        return dp[idx][sum+1001] = pos+neg;
    }
}