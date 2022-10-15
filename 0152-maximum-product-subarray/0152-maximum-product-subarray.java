class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int proFront = 1;
        int proBack = 1;
        
        int res = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            proFront = proFront*nums[i];
            proBack = proBack*nums[n-i-1];
            
            res = Math.max(res,Math.max(proFront,proBack));
            if(proFront==0){
                proFront = 1;
            }
            
            if(proBack==0){
                proBack = 1;
            }
            
        }
        
        return res;
    }
}