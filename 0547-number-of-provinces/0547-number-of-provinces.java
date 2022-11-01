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
                    if(isUnion(i,j,parent)){
                        count--;
                    }
                }
            }
        }
        
        
        return count;
    }
    
    public boolean isUnion(int i,int j,int parent[]){
        int px = find(i,parent);
        int py = find(j,parent);
        
        if(px==py){
            return false;
        }
        
        parent[py]  = px;
        return true;
    }
    
    public int find(int i,int parent[]){
        if(parent[i]==i){
            return i;
        }
        
        return parent[i] = find(parent[i],parent);
    }
}