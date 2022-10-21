class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int currFarthest = 0;
        
        for(int i=0;i<nums.length-1;i++){
            currFarthest = Math.max(nums[i]+i,currFarthest);
            if(i==currEnd){
                jumps++;
                currEnd = currFarthest;
            }
        }
        
        return jumps;
    }
}