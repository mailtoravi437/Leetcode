class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = 0;
        int max = 0;
        int sum = 0;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            min = Math.min(min,sum);
            max = Math.max(max,sum);
        }
        
        return max-min;
    }
}