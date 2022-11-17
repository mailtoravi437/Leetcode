class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hset = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hset.add(nums[i]);
        }
        
        int res = 0;
        
        for(int num : nums){
            if(!hset.contains(num-1)){
                int currNum = num;
                int currStreak = 1;
                
                while(hset.contains(currNum+1)){
                    currNum = currNum+1;
                    currStreak++;
                }
                
                res = Math.max(res,currStreak);
            }
        }
        
        return res;
    }
}