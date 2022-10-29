class Solution {
    public int countTriplets(int[] nums) {
        int res[] = new int[1<<16];
        for(int a : nums){
            for(int b : nums){
                res[a&b]++;
            }
        }
        
        int count = 0;
        
        for(int i=0;i<res.length;i++){
            for(int a : nums){
                if((i&a)==0){
                    count += res[i];
                }
            }
        }
        
        return count;
    }
}