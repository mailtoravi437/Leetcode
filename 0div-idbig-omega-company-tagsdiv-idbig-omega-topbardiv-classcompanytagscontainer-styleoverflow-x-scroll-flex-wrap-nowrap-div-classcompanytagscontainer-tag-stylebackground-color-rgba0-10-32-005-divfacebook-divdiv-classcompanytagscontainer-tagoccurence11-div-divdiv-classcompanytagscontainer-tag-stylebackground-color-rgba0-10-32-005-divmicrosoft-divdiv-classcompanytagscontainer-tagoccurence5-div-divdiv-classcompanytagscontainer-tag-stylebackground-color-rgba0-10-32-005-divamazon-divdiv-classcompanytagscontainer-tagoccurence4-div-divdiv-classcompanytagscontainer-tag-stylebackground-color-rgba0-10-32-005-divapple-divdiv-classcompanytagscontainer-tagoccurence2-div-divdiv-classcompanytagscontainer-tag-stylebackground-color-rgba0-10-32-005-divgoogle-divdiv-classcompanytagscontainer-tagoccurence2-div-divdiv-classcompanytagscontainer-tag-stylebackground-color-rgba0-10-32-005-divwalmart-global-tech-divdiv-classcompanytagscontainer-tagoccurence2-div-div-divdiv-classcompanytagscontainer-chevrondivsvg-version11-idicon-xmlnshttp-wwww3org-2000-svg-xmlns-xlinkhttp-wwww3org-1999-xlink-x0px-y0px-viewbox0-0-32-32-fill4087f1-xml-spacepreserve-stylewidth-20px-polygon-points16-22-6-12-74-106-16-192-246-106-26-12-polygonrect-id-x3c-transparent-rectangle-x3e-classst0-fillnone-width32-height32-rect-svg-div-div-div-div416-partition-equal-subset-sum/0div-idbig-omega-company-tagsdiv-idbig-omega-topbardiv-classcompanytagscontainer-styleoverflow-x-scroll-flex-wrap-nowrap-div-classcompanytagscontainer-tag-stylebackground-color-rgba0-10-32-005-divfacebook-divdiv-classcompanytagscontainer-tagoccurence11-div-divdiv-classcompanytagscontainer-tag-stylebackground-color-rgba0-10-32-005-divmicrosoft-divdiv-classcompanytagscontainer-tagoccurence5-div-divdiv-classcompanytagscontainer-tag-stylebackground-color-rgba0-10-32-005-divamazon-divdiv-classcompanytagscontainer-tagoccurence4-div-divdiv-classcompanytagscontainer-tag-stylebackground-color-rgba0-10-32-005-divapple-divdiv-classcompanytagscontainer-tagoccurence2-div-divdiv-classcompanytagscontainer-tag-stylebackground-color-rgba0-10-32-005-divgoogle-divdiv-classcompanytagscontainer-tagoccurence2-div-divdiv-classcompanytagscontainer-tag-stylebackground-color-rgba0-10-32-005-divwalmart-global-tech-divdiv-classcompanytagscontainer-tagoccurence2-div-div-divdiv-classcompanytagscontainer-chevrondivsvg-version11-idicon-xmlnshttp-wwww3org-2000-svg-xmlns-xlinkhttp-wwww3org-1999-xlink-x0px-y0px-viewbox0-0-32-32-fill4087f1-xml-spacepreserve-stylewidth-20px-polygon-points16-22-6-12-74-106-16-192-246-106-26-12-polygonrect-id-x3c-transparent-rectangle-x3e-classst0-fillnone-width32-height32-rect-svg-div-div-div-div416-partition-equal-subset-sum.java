class Solution {
    Boolean memo[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        
        memo = new Boolean[sum/2+1][n+1];
        
        if(sum%2!=0){
            return false;
        }
        
        return solve(nums,sum/2,0);
    }
    
    public boolean solve(int nums[],int sum,int index){
        if(index>=nums.length || sum<0){
            return false;
        }
        
        if(sum==0){
            return true;
        }
        
        if(memo[sum][index]!=null){
            return memo[sum][index];
        }
        
        return memo[sum][index] = solve(nums,sum-nums[index],index+1) || solve(nums,sum,index+1);
    }
}