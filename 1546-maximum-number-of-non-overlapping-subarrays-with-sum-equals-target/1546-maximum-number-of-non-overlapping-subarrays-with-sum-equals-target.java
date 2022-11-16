class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,0);
        int sum = 0;
        int res = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            if(hmap.containsKey(sum-target)){
                res = Math.max(res,hmap.get(sum-target)+1);
            }
            
            hmap.put(sum,res);
        }
        
        return res;
    }
}