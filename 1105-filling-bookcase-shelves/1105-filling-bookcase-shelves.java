class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        Integer dp[][] = new Integer[n+2][shelfWidth+2];
        return sol(books,shelfWidth,0,0,0,dp);
    }
    
    public int sol(int books[][],int maxWidth,int idx,int width,int lastheight,Integer dp[][]){
        if(idx>=books.length){
            return lastheight;
        }
        
        if(dp[idx][width]!=null){
            return dp[idx][width];
        }
        
        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        
        if(width+books[idx][0]<=maxWidth){
            op1 = sol(books,maxWidth,idx+1,width+books[idx][0],Math.max(lastheight,books[idx][1]),dp);
        }
        
        op2 = lastheight+sol(books,maxWidth,idx+1,books[idx][0],books[idx][1],dp);
        
        return dp[idx][width] = Math.min(op1,op2);
    }
}