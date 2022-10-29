class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int count[][] = new int[strs.length][2];
        
        for(int i=0;i<strs.length;i++){
            count[i] = getCount(strs[i]);
        }
        
        Integer dp[][][] = new Integer[strs.length+2][m+2][n+2];
        return sol(count,m,n,dp,0);
    }
    
    public int sol(int count[][],int m,int n,Integer dp[][][],int idx){
        if(idx>=count.length){
            return 0;
        }
        
        if(dp[idx][m][n]!=null){
            return dp[idx][m][n];
        }
        
        int remainingZero = m-count[idx][0];
        int remainingOne = n-count[idx][1];
        
        int include = 0;
        int exclude = 0;
        
        if(remainingZero>=0 && remainingOne>=0){
            include = 1+sol(count,remainingZero,remainingOne,dp,idx+1);
        }
        
        exclude = sol(count,m,n,dp,idx+1);
        
        return dp[idx][m][n] = Math.max(include,exclude);
    }
    
    public int[] getCount(String str){
        int count[] = new int[2];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'0']++;
        }
        
        return count;
    }
}