class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res1 = sol(nums,0,nums.length-2);
        int res2 = sol(nums,1,nums.length-1);
        
        return Math.max(res1,res2);
    }
    
    public int sol(int nums[],int s,int e){
        int include = 0;
        int exclude = 0;
        for(int i=s;i<=e;i++){
            int temp = exclude;
            if(nums[i]+include>exclude){
                exclude = nums[i]+include;
            }
            
            include = temp;
        }
        
        return exclude;
    }
}