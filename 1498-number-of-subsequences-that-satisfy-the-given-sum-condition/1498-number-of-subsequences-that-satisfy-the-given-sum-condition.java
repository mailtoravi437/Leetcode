class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int)1e9+7;
        int n = nums.length;
        int pre[] = new int[n];
        pre[0] = 1;
        for(int i=1;i<n;i++){
            pre[i] = (pre[i-1]*2)%mod;
        }
        
        int i = 0;
        int j = n-1;
        
        int count = 0;
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count = (count+pre[j-i])%mod;
                i++;
            }
            else if(nums[i]+nums[j]>target){
                j--;
            }
        }
        
        return count;
    }
}