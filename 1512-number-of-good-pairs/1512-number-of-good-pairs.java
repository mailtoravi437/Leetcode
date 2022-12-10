class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int ans = hmap.getOrDefault(nums[i],0);
            res += ans;
            hmap.put(nums[i],ans+1);
        }
        
        return res;
    }
}