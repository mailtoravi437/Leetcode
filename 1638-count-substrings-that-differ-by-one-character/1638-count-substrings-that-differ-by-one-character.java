class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int dp[][][] = new int[n+1][m+1][2];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i+1][j+1][0] = (s.charAt(i)==t.charAt(j))?dp[i][j][0]+1:0;
                dp[i+1][j+1][1] = (s.charAt(i)==t.charAt(j))?dp[i][j][1]:dp[i][j][0]+1;
                res += dp[i+1][j+1][1];
            }
        }
        
        return res;
    }
}