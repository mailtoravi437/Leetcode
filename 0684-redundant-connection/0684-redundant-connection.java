class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        int parent[] = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            if(find(u,parent)==find(v,parent)){
                return edge;
            }
            
            else{
                int px = find(u,parent);
                int py = find(v,parent);
                
                parent[py] = px;
            }
        }
        
        return new int[2];
    }
    
    public int find(int x,int parent[]){
        if(x==parent[x]){
            return x;
        }
        
        return find(parent[x],parent);
    }
}