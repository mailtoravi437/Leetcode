class Solution {
    int parent[];
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
        int m = isConnected[0].length;
        
        parent = new int[n*m];
        for(int i=0;i<(n*m);i++){
            parent[i] = i;
        }
        int count = n;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(isConnected[i][j]==1){
                    if(union(i,j,parent)){
                    count--;
                }
               }
            }
        }
        
        return count;
    }
    
    public boolean union(int x,int y,int parent[]){
        int px = find(x,parent);
        int py = find(y,parent);
        
        if(px==py){
            return false;
        }
        
        parent[py] = px;
        return true;
    }
    
    public int find(int x,int parent[]){
        return (parent[x]==x?x:(parent[x]=find(parent[x],parent)));
    }
}