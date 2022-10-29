class Solution {
    public int countTriplets(int[] nums) {
        int res[] = new int[1<<16];
        for(int a : nums){
            for(int b : nums){
                res[a&b]++;
            }
        }
        
        int ans = 0;
        for(int a : nums){
            for(int i=0;i<res.length;i++){
                if((a&i)==0){
                    ans += res[i];
                }
            }
        }
        
        return ans;
    }
}