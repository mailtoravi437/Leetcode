class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int maxK = Integer.MIN_VALUE;
        for(int i=0;i<cols;i++){
            int dp[] = new int[rows];
            for(int j=i;j<cols;j++){
                for(int l=0;l<rows;l++){
                    dp[l] += matrix[l][j];
                }
                
                int currSum = maxSol(dp,k);
                maxK = Math.max(currSum,maxK);
                
                if(maxK==k){
                    return k;
                }
            }
        }
        
        return maxK;
    }
    
    public int maxSol(int dp[],int k){
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        
        TreeSet<Integer> hset = new TreeSet<>();
        hset.add(0);
        for(int a : dp){
            currSum += a;
            
            Integer ceilValue = hset.ceiling(currSum-k);
            if(ceilValue!=null){
                            max = Math.max(max,currSum-ceilValue);

            }
            
            hset.add(currSum);
        }
        
        return max;
    }
}