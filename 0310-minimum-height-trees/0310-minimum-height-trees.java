class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<2){
            ArrayList<Integer> centroid = new ArrayList<>();
            for(int i=0;i<n;i++){
                centroid.add(i);
            }

            return centroid;
        }

        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        for(int i=0;i<n;i++){
            alist.add(new ArrayList<>());
        }
        
        int inDegree[] = new int[n];

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            alist.get(v).add(u);
            alist.get(u).add(v);
            
            inDegree[u]++;
            inDegree[v]++;
            
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(inDegree[i]==1){
                queue.add(i);
            }
        }
        
        int size = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!queue.isEmpty()){
            res = new ArrayList<>();
            size = queue.size();
            
            for(int i=0;i<size;i++){
                int node = queue.poll();
                res.add(node);
                
                Iterator<Integer> it = alist.get(node).listIterator();
                while(it.hasNext()){
                    int m = it.next();
                    inDegree[m]--;
                    if(inDegree[m]==1){
                        queue.add(m);
                    }
                }
            }
        }
        
        return res;
    }
}