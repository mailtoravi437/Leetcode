class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        int  n= nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            int mod = k==0?sum:sum%k;
            if(hmap.containsKey(mod) && i-hmap.get(mod)>1){
                return true;
            }
            
            hmap.putIfAbsent(mod,i);
        }
        
        return false;
    }
}