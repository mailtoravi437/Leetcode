class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0){
            return;
        }
        
        int insertIdx = 0;
        for(int x : nums){
            if(x!=0){
                nums[insertIdx++] = x;
            }
        }
        
        while(insertIdx<nums.length){
            nums[insertIdx++] = 0;
        }
        

    }
}