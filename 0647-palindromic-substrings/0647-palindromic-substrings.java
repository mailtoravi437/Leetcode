class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean dp[][] = new boolean[n][n];
        
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j] = true;
                }
                else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]==true){
                            dp[i][j] = true;
                        }
                    }
                }
                
                if(dp[i][j]){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}