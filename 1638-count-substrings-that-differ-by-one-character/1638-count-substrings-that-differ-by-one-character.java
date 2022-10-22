class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int res = 0;
        
        int dp[][][] = new int[m+1][n+1][2];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1][0] = s.charAt(i)==t.charAt(j)? dp[i][j][0]+1:0;
                dp[i+1][j+1][1] = s.charAt(i)==t.charAt(j)?dp[i][j][1] :dp[i][j][0]+1;
                
                res += dp[i+1][j+1][1];
             }
        }
        
        return res;
    }
}