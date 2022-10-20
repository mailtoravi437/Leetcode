class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        return sol(0,0,target,nums,count);
    }
    
    public int sol(int idx,int sum,int target,int nums[],int count){
        if(idx==nums.length){
            if(sum==target){
                count++;
            }
            return count;

        }
        
        
        
        int pos = sol(idx+1,sum+nums[idx],target,nums,count);
        int neg = sol(idx+1,sum-nums[idx],target,nums,count);
        
        return pos+neg;
    }
}