class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            int required = target-nums[i];
            if(hmap.containsKey(required)){
                return new int[]{hmap.get(required),i};
            }
            
            hmap.put(nums[i],i);
        }
        
        return new int[]{};
    }
}