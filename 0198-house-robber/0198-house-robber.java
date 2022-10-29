class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return helper(nums,0,n-1);
    }
    
    public int helper(int nums[],int low,int high){
        int include = 0;
        int exclude = 0;
        
        for(int i=low;i<=high;i++){
            int in = include;
            int ex = exclude;
            
            include = ex+nums[i];
            exclude = Math.max(in,ex);
        }
        
        return Math.max(include,exclude);
    }
}