class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer dp[] = new Integer[n+2];
        return sol(days,costs,dp,0);
    } 
    
    public int  sol(int days[],int costs[],Integer dp[],int idx){
        if(idx>=days.length){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        int oneDay = costs[0]+sol(days,costs,dp,idx+1);
        int i;
        for(i=idx;i<days.length;i++){
            if(days[i]>=days[idx]+7){
                break;
            }
        }
        
        int sevenDay = costs[1]+sol(days,costs,dp,i);
        for(i=idx;i<days.length;i++){
            if(days[i]>=days[idx]+30){
                break;
            }
        }
        
        int thirtyDay = costs[2]+sol(days,costs,dp,i);
        
        return dp[idx] = Math.min(oneDay,Math.min(sevenDay,thirtyDay));
    }
}