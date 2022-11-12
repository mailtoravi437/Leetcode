class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;
        int nums[] = new int[n+2];
        nums[0] = 1;
        nums[n+1] = 1;
        int i = 1;
        for(int x : arr){
            nums[i++] = x;
        }
        
        Integer dp[][] = new Integer[n+2][n+2];
        return sol(nums,1,n,dp);
    }
    
    public int sol(int nums[],int beg,int end,Integer dp[][]){
        if(beg>end){
            return 0;
        }
        
        if(dp[beg][end]!=null){
            return dp[beg][end];
        }
        
        int ans = Integer.MIN_VALUE;
        for(int k=beg;k<=end;k++){
            int left = sol(nums,beg,k-1,dp);
            int right = sol(nums,k+1,end,dp);
            
            int val = nums[beg-1]*nums[k]*nums[end+1];
            
            ans = Math.max(ans,left+right+val);
        }
        
        return dp[beg][end] = ans;
    }
}