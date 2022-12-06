class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        
        if(image[sr][sc]==color){
            return image;
        }
        
        int oldColor = image[sr][sc];
        
        sol(image,sr,sc,color,oldColor);
        return image;
    }
    
    public void sol(int image[][],int sr,int sc,int color,int oldColor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=oldColor){
            return;
        }
        
        image[sr][sc] = color;
        sol(image,sr+1,sc,color,oldColor);
        sol(image,sr-1,sc,color,oldColor);
        sol(image,sr,sc+1,color,oldColor);
        sol(image,sr,sc-1,color,oldColor);
    }
}