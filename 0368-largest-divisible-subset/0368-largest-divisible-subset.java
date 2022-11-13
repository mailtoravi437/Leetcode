class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(hash,-1);
        Arrays.sort(nums);
        int maxIdx = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
                
                if(dp[i]>dp[maxIdx]){
                    maxIdx = i;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(maxIdx>=0){
            res.add(nums[maxIdx]);
            maxIdx = hash[maxIdx];
        }
        
        return res;
    }
}