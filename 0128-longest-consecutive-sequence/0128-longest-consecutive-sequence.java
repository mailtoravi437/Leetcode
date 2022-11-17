class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> hset = new HashSet<>();
        for(int x : nums){
            hset.add(x);
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(!hset.contains(nums[i]-1)){
                int currNum = nums[i];
                int currStreak = 1;
                
                while(hset.contains(currNum+1)){
                    currNum++;
                    currStreak = currStreak+1;
                }
                
                ans = Math.max(ans,currStreak);
            }
        }
        
        return ans;
    }
}