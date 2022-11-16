class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int sta[] = new int[n];
        int tmp[] = new int[n];
        
        Arrays.fill(sta,Integer.MAX_VALUE);
        Arrays.fill(tmp,Integer.MAX_VALUE);
        
        sta[src] = 0;
        
        for(int i=0;i<=k;i++){
            for(int j=0;j<flights.length;j++){
                int sta_src = flights[j][0];
                int sta_dest = flights[j][1];
                int cost = flights[j][2];
                
                if(sta[sta_src]!=Integer.MAX_VALUE && sta[sta_src]+cost<tmp[sta_dest]){
                    tmp[sta_dest] = sta[sta_src]+cost;
                }
            }
            
            for(int p=0;p<n;p++){
                sta[p] = tmp[p];
            }
        }
        
        return sta[dst]==Integer.MAX_VALUE?-1:sta[dst];
    }
}