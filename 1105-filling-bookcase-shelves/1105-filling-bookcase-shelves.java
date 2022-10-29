class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        Integer dp[][] = new Integer[n+2][shelfWidth+2];
        return sol(books,shelfWidth,0,0,0,dp);
    }
    
    public int sol(int books[][],int shelfWidth,int idx,int lHeight,int width,Integer dp[][]){
        if(idx>=books.length){
            return lHeight;
        }
        
        if(dp[idx][width]!=null){
            return dp[idx][width];
        }
        
        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        
        if(width+books[idx][0]<=shelfWidth){
            op1 = sol(books,shelfWidth,idx+1,Math.max(lHeight,books[idx][1]),width+books[idx][0],dp);
        }
        
        op2 = lHeight+sol(books,shelfWidth,idx+1,books[idx][1],books[idx][0],dp);
        
        return dp[idx][width] = Math.min(op1,op2);
    }
}
