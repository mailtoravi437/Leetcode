class Solution {
    public int findCircleNum(int[][] isConnected) {
        int M = isConnected.length;
        int N = isConnected[0].length;
        
        if(M==0 || N==0){
            return 0;
        }
        
        UnionFind uf = new UnionFind(M);
        for(int i=0;i<M;i++){
            for(int j=i+1;j<N;j++){
                if(isConnected[i][j]==1){
                    uf.unite(i,j);
                }
            }
        }
        
        Set<Integer> hset = new HashSet<>();
        
        for(int i=0;i<M;i++){
            if(uf.f[i]==uf.find(i)){
                hset.add(uf.f[i]);
            }
        }
        
        return hset.size();
    }
}

class UnionFind{
    int f[];
    public UnionFind(int size){
        f = new int[size];
        for(int i=0;i<size;i++){
            f[i] = i;
        }
    }
    
    public int find(int x){
        if(f[x]!=x){
            f[x] =  find(f[x]);
        }
        
        return f[x];
    }
    
    public void unite(int x,int y){
        int fx = find(x);
        int fy = find(y);
        
        f[f[y]] = fx; 
    }
}
