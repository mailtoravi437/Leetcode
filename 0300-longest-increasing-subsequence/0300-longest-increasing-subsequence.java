class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            int idx = binary_search(dp,0,n-1,nums[i]);
            
            if(nums[i]>dp[idx-1] && nums[i]<dp[idx]){
                dp[idx] = nums[i];
            }
        }
        
        int ma = n;
        
        for(int i=n;i>=0;i--){
            if(dp[i]!=Integer.MAX_VALUE){
                ma = i;
                break;
            }
        }
        
        return ma;
    }
    
    public int binary_search(int dp[],int s,int e,int key){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(dp[mid]==key){
                return mid;
            }
            
            else if(dp[mid]<key){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        
        return s;
    }
}