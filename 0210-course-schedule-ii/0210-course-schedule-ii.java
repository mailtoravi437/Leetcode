class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
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
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int x = queue.poll();
            ans.add(x);
            
            Iterator<Integer> it = alist.get(x).listIterator();
            while(it.hasNext()){
                int m = it.next();
                inDegree[m]--;
                if(inDegree[m]==0){
                    queue.add(m);
                }
            }
        }
        
        if(ans.size()!=n){
            return new int[0];
        }
        
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = ans.get(i);
        }
        
        return res;
    }
}