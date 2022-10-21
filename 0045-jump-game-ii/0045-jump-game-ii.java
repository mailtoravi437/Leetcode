class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farEnd = 0;
        
        for(int i=0;i<nums.length-1;i++){
            farEnd = Math.max(farEnd,nums[i]+i);
            if(currEnd==i){
                jumps++;
                currEnd = farEnd;
            }
        }
        
        return jumps;
    }
}