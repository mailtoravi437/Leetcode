class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int dis[] = new int[n];
        
        Arrays.fill(lis,1);
        Arrays.fill(dis,1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && lis[j]+1>lis[i]){
                    lis[i] = lis[j]+1;
                }
            }
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && dis[j]+1>dis[i]){
                    dis[i] = dis[j]+1;
                }
            }
        }
        
        int max = 0;
        for(int i=0;i<n;i++){
            if(lis[i]==1 || dis[i]==1){
                continue;
            }
            
            max = Math.max(lis[i]+dis[i]-1,max);
        }
        
        return n-max;
    }
}