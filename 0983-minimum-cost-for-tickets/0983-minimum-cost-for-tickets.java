class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer dp[] = new Integer[n+2];
        return sol(days,costs,0,dp);
    }
    
    public int sol(int days[],int costs[],int idx,Integer dp[]){
        if(idx>=days.length){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int oneDay = costs[0]+sol(days,costs,idx+1,dp);
        int i;
        for(i=idx;i<days.length;i++){
            if(days[i]>=days[idx]+7){
                break;
            }
        }
        
        int sevenDay = costs[1]+sol(days,costs,i,dp);
        
        for(i=idx;i<days.length;i++){
            if(days[i]>=days[idx]+30){
                break;
            }
        }
        
        int thirtyDay = costs[2]+sol(days,costs,i,dp);
        
        dp[idx] = Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        
        return dp[idx];
        
    }
}