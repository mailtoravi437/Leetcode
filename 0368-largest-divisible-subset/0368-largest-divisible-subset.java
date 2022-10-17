class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(hash,-1);
        Arrays.sort(nums);
        
        int maxIdx = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                    
                    if(dp[maxIdx]<dp[i]){
                        maxIdx = i;
                    }
                }
            }
        }
        
        List<Integer> alist = new ArrayList<>();
        while(maxIdx>=0){
            alist.add(nums[maxIdx]);
            maxIdx = hash[maxIdx];
        }
        
        return alist;
    }
}