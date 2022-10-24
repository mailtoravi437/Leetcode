class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i,j,0,board,word,visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int i,int j,int index,char board[][],String word,boolean visited[][]){
        if(i==-1 || i==board.length || j==-1 || j==board[0].length || visited[i][j]==true || word.charAt(index)!=board[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(index==word.length()-1){
            return true;
        }
        index++;
        if(dfs(i+1,j,index,board,word,visited) ||
        dfs(i-1,j,index,board,word,visited) ||
        dfs(i,j-1,index,board,word,visited) ||
        dfs(i,j+1,index,board,word,visited)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}