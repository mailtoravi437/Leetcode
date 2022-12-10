class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res[] = new int[101];
        int count = 0;
        for(int a : nums){
            count += res[a]++;
        }
        return count;
    }
}