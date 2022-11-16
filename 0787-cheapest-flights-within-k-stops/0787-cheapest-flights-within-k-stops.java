class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int sta[] = new int[n];
        int tmp[] = new int[n];
        
        Arrays.fill(sta,Integer.MAX_VALUE);
        Arrays.fill(tmp,Integer.MAX_VALUE);
        
        sta[src] = 0;
        
        for(int i=0;i<=k;i++){
            for(int j=0;j<flights.length;j++){
                int src_temp = flights[j][0];
                int dest_temp = flights[j][1];
                int cost = flights[j][2];
                
                if(sta[src_temp]!=Integer.MAX_VALUE && sta[src_temp]+cost<tmp[dest_temp]){
                    tmp[dest_temp] = sta[src_temp]+cost;
                }
            }
            
            for(int p=0;p<n;p++){
                sta[p] = tmp[p];
            }
        }
        
        return sta[dst]==Integer.MAX_VALUE?-1:sta[dst];
    }
}