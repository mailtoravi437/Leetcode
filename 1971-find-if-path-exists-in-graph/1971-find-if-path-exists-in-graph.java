class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        for(int i=0;i<n;i++){
            alist.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            alist.get(u).add(v);
            alist.get(v).add(u);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited,false);
        
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int temp = queue.poll();
                if(temp==destination){
                        return true;
                    }
                Iterator<Integer> it = alist.get(temp).listIterator();
                while(it.hasNext()){
                    int m = it.next();
                    
                    if(visited[m]==false){
                        queue.add(m);
                        visited[m] = true;
                    }
                    
                }
            }
        }
        
        return false;
    }
}