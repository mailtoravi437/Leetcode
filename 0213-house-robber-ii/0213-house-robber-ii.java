class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        return Math.max(sol(nums,0,nums.length-2),sol(nums,1,nums.length-1));
    }
    
    public int sol(int nums[],int s,int e){
        int include = 0;
        int exclude = 0;
        
        for(int i=s;i<=e;i++){
            int in = include;
            int ex = exclude;
            
            include = ex+nums[i];
            
            exclude = Math.max(in,ex);
        }
        
        return Math.max(include,exclude);
    }
}