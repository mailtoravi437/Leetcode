class Solution {
    public int subsetXORSum(int[] nums) {
        return sol(nums,0,0);
    }
    
    public int sol(int nums[],int idx,int currXor){
        if(idx==nums.length){
            return currXor;
        }
        
        int withElement = sol(nums,idx+1,currXor^nums[idx]);
        int withOut = sol(nums,idx+1,currXor);
        
        return withElement+withOut;
    }
}