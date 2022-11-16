class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return false;
        }
        
        Set<Integer> hset = new HashSet<>();
        for(int i=0;i<n-1;i++){
            int sum = nums[i]+nums[i+1];
            if(hset.contains(sum)){
                return true;
            }
            
            hset.add(sum);
        }
        
        return false;
    }
}