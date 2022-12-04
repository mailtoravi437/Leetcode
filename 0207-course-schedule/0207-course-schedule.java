class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        if(n==0){
            return false;
        }
        
        List<List<Integer>> alist = new ArrayList<>();
        for(int i=0;i<n;i++){
            alist.add(new ArrayList<>());
        }
        
        int inDegree[] = new int[n];
        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];
            
            alist.get(v).add(u);
            inDegree[u]++;
        }
        
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int x = queue.poll();
                ans++;
                Iterator<Integer> it = alist.get(x).listIterator();
                while(it.hasNext()){
                    int m = it.next();
                    inDegree[m]--;
                    if(inDegree[m]==0){
                        queue.add(m);
                    }
                }
            }
        }
        
        return ans==n;
    }
}