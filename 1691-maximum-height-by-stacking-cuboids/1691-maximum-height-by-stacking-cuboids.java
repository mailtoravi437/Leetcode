class Solution {
    public int maxHeight(int[][] arr) {
        for(int cub[] : arr){
            Arrays.sort(cub);
        }
                    Arrays.sort(arr,(a,b)->(a[0]+a[1]+a[2])-(b[0]+b[1]+b[2]));

        
        int n = arr.length;
        int dp[] = new int[n];
        int max = 0;
        
        for(int i=0;i<n;i++){
            dp[i] = arr[i][2];
            
            for(int j=0;j<i;j++){
                if(arr[i][0]>=arr[j][0] && arr[i][1]>=arr[j][1] && arr[i][2]>=arr[j][2]){
                    dp[i]  = Math.max(dp[i],dp[j]+arr[i][2]);
                }
            }
            
            max = Math.max(max,dp[i]);
        }
        
        return max;
    }
}